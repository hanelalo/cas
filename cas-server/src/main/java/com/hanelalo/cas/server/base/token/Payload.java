package com.hanelalo.cas.server.base.token;


import com.google.common.collect.Lists;
import com.hanelalo.cas.server.user.Authority;

import java.io.Serializable;
import java.util.List;

public class Payload implements Serializable {

  private static final long serialVersionUID = -3494565427417504138L;
  private String clientId;
  private String userId;
  private long createDate;
  private long validTime;
  private List<Authority> authorities = Lists.newArrayList();
  private String accessToken="";

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
  public Payload setClientId(String clientId) {
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
  public Payload setUserId(String userId) {
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
  public Payload setCreateDate(long createDate) {
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
  public Payload setValidTime(long validTime) {
    this.validTime = validTime;
    return this;
  }

  public List<Authority> getAuthorities() {
    return authorities;
  }

  public Payload setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
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
  public Payload setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
