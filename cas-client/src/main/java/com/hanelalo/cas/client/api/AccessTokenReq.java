package com.hanelalo.cas.client.api;


import java.io.Serializable;

public class AccessTokenReq extends CasServerResult {

  private static final long serialVersionUID = 2619918873664608633L;
  private String userId;
  private String password;

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
  public AccessTokenReq setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get password
   **/
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   * @return this
   **/
  public AccessTokenReq setPassword(String password) {
    this.password = password;
    return this;
  }
}
