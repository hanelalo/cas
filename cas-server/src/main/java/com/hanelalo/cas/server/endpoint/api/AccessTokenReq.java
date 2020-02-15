package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotNull;

@ApiModel("Token请求")
public class AccessTokenReq implements Serializable {
  private static final long serialVersionUID = -1544211586429069210L;
  @NotNull
  @ApiModelProperty("用户ID")
  private String userId;
  @NotNull
  @ApiModelProperty("密码")
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
