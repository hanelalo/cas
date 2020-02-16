package com.hanelalo.cas.client.api;


import java.io.Serializable;

public class TokenInfoReq implements Serializable {

  private static final long serialVersionUID = 811509703888704269L;
  private String accessToken;

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
  public TokenInfoReq setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }
}
