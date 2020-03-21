package com.hanelalo.cas.server.base.token;

import com.google.common.collect.Maps;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.hanelalo.cas.server.config.AuthServerProperties;
import com.hanelalo.cas.server.service.core.AccessToken;
import com.hanelalo.cas.server.user.UserDetails;

import java.util.Map;

public abstract class AbstractTokenProcessor {

  private static final String TOKEN_TYPE = "Bearer ";
  private TokenHelper tokenHelper;
  private AuthServerProperties properties;

  public AccessToken buildAccessToken(UserDetails details) {
    Payload payload = buildPayLoad(details, "");
    Map<String, String> headers = buildHeaders();
    return accessToken(payload, headers);
  }


  public Payload readPayload(String token) {
    token = token.replace(TOKEN_TYPE, "");
    return tokenHelper.decode(token);
  }

  private AccessToken accessToken(Payload payload, Map<String, String> headers) {
    String accessToken = tokenHelper.encode(payload, headers);
    String refreshToken = buildRefreshToken(accessToken, payload);
    return new AccessToken()
        .setClientId(payload.getClientId())
        .setAccessToken(accessToken)
        .setRefreshToken(refreshToken)
        .setUser(payload.getUserId())
        .setJti(getJti(accessToken))
        .setAuthorities(payload.getAuthorities());
  }

  private String getJti(String accessToken) {
    HashFunction sha = Hashing.sha256();
    return sha.hashBytes(accessToken.getBytes()).toString();
  }

  private String buildRefreshToken(String accessToken, Payload payload) {
    payload.setAccessToken(accessToken);
    Map<String, String> headers = buildHeaders();
    return tokenHelper.encode(payload, headers);
  }

  private Map<String, String> buildHeaders() {
    Map<String, String> headers = Maps.newHashMap();
    headers.put("alg", "RSA");
    headers.put("typ", "JWT");
    return headers;
  }

  public abstract Payload buildPayLoad(UserDetails details, String accessToken);
  /*{
    CasServerPreconditions.checkClientError(details instanceof DefaultUserDetails);
    DefaultUserDetails defaultUserDetails = (DefaultUserDetails) details;
    ClientDetails client = CasRequestContext.get(ClientDetails.class);
    List<String> roles = details.getRoles().stream()
        .map(RoleType::getRole)
        .collect(Collectors.toList());
    return new Payload().setClientId(client.getClientId())
        .setCreateDate(System.currentTimeMillis())
        .setValidTime(properties.getValidTime())
        .setUserId(defaultUserDetails.getUserId())
        .setAccessToken(accessToken)
        .setRoles(roles);
  }*/

  public TokenHelper getTokenHelper() {
    return tokenHelper;
  }

  public void setTokenHelper(TokenHelper tokenHelper) {
    this.tokenHelper = tokenHelper;
  }

  public AuthServerProperties getProperties() {
    return properties;
  }

  public void setProperties(AuthServerProperties properties) {
    this.properties = properties;
  }
}
