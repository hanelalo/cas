package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("refreshToken")
public class RefreshToken implements Serializable {
  private static final long serialVersionUID = 3064440265630391819L;
  @ApiModelProperty("refresh token")
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