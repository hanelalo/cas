package com.hanelalo.cas.client.api;


import java.io.Serializable;

public class RefreshTokenReq implements Serializable {

  private static final long serialVersionUID = -8941158773054945219L;
  private String refreshToken;

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
  public RefreshTokenReq setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}
