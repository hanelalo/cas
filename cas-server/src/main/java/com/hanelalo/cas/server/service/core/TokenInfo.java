package com.hanelalo.cas.server.service.core;

import com.google.common.collect.Lists;
import java.util.List;

public class TokenInfo {

  private String clientId;
  private String userId;
  private long createDate;
  private long validTime;
  private List<String> roles = Lists.newArrayList();

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
   * @param createDate
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
   * @param validTime
   * @return this
   **/
  public TokenInfo setValidTime(long validTime) {
    this.validTime = validTime;
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
  public TokenInfo setRoles(List<String> roles) {
    this.roles = roles;
    return this;
  }
}
