package com.hanelalo.cas.client.api;

import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

public class TokenInfoResp extends CasServerResult {

  private static final long serialVersionUID = 4991108289017136648L;
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
  public TokenInfoResp setClientId(String clientId) {
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
  public TokenInfoResp setUserId(String userId) {
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
  public TokenInfoResp setCreateDate(long createDate) {
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
  public TokenInfoResp setValidTime(long validTime) {
    this.validTime = validTime;
    return this;
  }

  public List<Authority> getAuthorities() {
    return authorities;
  }

  public TokenInfoResp setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }
}
