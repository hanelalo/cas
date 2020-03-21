package com.hanelalo.cas.server.endpoint.api;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.base.CasServerResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("TokenInfo响应对象")
public class TokenInfoResp extends CasServerResult {

  private static final long serialVersionUID = -8991066570192941876L;
  @ApiModelProperty("客户端ID")
  private String clientId;
  @ApiModelProperty("用户id")
  private String userId;
  @ApiModelProperty("token创建时间（ms）")
  private long createDate;
  @ApiModelProperty("token有效期（ms）")
  private long validTime;
  @ApiModelProperty("用户权限")
  private List<AuthorityDto> authorities = Lists.newArrayList();

  /**
   * Get clientId
   **/
  public String getClientId() {
    return clientId;
  }

  /**
   * @param clientId clientId
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
   * @param userId userId
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
   * @param createDate createDate
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
   * @param validTime validTime
   * @return this
   **/
  public TokenInfoResp setValidTime(long validTime) {
    this.validTime = validTime;
    return this;
  }

  /**
   * Get authorities
   **/
  public List<AuthorityDto> getAuthorities() {
    return authorities;
  }

  /**
   * @param authorities authorities
   * @return this
   **/
  public TokenInfoResp setAuthorities(List<AuthorityDto> authorities) {
    this.authorities = authorities;
    return this;
  }
}
