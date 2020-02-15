package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel("Token 响应")
public class AccessTokenResp implements Serializable {
  private static final long serialVersionUID = 3319497958037464600L;
  @ApiModelProperty("用户")
  private String user;
  @ApiModelProperty("token id")
  private String jti;
  @ApiModelProperty("token")
  private String accessToken;
  @ApiModelProperty("用户角色")
  private String roles;
  @ApiModelProperty("刷新token")
  private RefreshToken refreshToken;

  /**
   * Get user
   **/
  public String getUser() {
    return user;
  }

  /**
   * @param user
   * @return this
   **/
  public AccessTokenResp setUser(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get jti
   **/
  public String getJti() {
    return jti;
  }

  /**
   * @param jti
   * @return this
   **/
  public AccessTokenResp setJti(String jti) {
    this.jti = jti;
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
  public AccessTokenResp setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  /**
   * Get roles
   **/
  public String getRoles() {
    return roles;
  }

  /**
   * @param roles
   * @return this
   **/
  public AccessTokenResp setRoles(String roles) {
    this.roles = roles;
    return this;
  }

  /**
   * Get refreshToken
   **/
  public RefreshToken getRefreshToken() {
    return refreshToken;
  }

  /**
   * @param refreshToken
   * @return this
   **/
  public AccessTokenResp setRefreshToken(RefreshToken refreshToken) {
    this.refreshToken = refreshToken;
    return this;
  }
}
