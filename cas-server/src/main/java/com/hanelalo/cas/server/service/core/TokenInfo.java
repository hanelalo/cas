package com.hanelalo.cas.server.service.core;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.user.Authority;

import java.util.List;

public class TokenInfo {

  private String clientId;
  private String userId;
  private long createDate;
  private long validTime;
  private List<Authority> authorities = Lists.newArrayList();

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
  public TokenInfo setClientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Get userId
   **/
  public String getUserId() {
    return userId;
  }

  /**
   * @param userId
   * @return this
   **/
  public TokenInfo setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get createDate
   **/
  public long getCreateDate() {
    return createDate;
  }

  /**
   * @param createDate createDate
   * @return this
   **/
  public TokenInfo setCreateDate(long createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * Get validTime
   **/
  public long getValidTime() {
    return validTime;
  }

  /**
   * @param validTime validTime
   * @return this
   **/
  public TokenInfo setValidTime(long validTime) {
    this.validTime = validTime;
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
  public TokenInfo setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }

}
