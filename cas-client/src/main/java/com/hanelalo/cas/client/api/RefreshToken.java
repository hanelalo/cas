package com.hanelalo.cas.client.api;


import java.io.Serializable;

public class RefreshToken implements Serializable {

  private static final long serialVersionUID = -3663790408239627406L;
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
  public RefreshToken setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}