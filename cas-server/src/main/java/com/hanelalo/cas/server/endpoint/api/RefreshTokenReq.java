package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("刷新token请求对象")
public class RefreshTokenReq implements Serializable {

  private static final long serialVersionUID = 5451683354970655272L;
  @ApiModelProperty("刷新token")
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
