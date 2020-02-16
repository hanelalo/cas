package com.hanelalo.cas.client.api;


import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

public class AccessTokenResp implements Serializable {
  private static final long serialVersionUID = -8560741426256123429L;
  private String user;
  private String jti;
  private String accessToken;
  private List<String> roles = Lists.newArrayList();
  private RefreshToken refreshToken;

  /**
   * Get user
   **/
  public String getUser() {
    return user;
  }

  /**
   * @param user
   * @return this
   **/
  public AccessTokenResp setUser(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get jti
   **/
  public String getJti() {
    return jti;
  }

  /**
   * @param jti
   * @return this
   **/
  public AccessTokenResp setJti(String jti) {
    this.jti = jti;
    return this;
  }

  /**
   * Get accessToken
   **/
  public String getAccessToken() {
    return accessToken;
  }

  /**
   * @param accessToken
   * @return this
   **/
  public AccessTokenResp setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * Get refreshToken
   **/
  public RefreshToken getRefreshToken() {
    return refreshToken;
  }

  /**
   * @param refreshToken
   * @return this
   **/
  public AccessTokenResp setRefreshToken(RefreshToken refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }

  /**
   * Get roles
   **/
  public List<String> getRoles() {
    return roles;
  }

  /**
   * @param roles
   * @return this
   **/
  public AccessTokenResp setRoles(List<String> roles) {
    this.roles = roles;
    return this;
  }
}
