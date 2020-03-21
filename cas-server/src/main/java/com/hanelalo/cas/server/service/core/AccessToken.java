package com.hanelalo.cas.server.service.core;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.user.Authority;

import java.util.List;

public class AccessToken {

  private String user;
  private String clientId;
  private String accessToken;
  private String refreshToken;
  private String jti;
  private List<Authority> authorities = Lists.newArrayList();

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
  public AccessToken setUser(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get clientId
   **/
  public String getClientId() {
    return clientId;
  }

  /**
   * @param clientId
   * @return this
   **/
  public AccessToken setClientId(String clientId) {
    this.clientId = clientId;
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
  public AccessToken setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * Get refreshToken
   **/
  public String getRefreshToken() {
    return refreshToken;
  }

  /**
   * @param refreshToken
   * @return this
   **/
  public AccessToken setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
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
  public AccessToken setJti(String jti) {
    this.jti = jti;
    return this;
  }

  /**
   * Get authorities
   **/
  public List<Authority> getAuthorities() {
    return authorities;
  }

  /**
   * @param authorities authorities
   * @return this
   **/
  public AccessToken setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }
}
