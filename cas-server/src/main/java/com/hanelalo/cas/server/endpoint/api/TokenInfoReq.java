package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel("TokenInfo 请求对象")
public class TokenInfoReq implements Serializable {
  private static final long serialVersionUID = -7826698830522510591L;
  @ApiModelProperty("token")
  @NotEmpty
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
