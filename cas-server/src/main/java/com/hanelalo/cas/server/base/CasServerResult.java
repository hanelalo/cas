package com.hanelalo.cas.server.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

@ApiModel
public class CasServerResult implements Serializable {
  private static final long serialVersionUID = 929306837821343325L;

  public CasServerResult(){}

  @ApiModelProperty("报错请求")
  private CasServerError error;

  /**
   * Get error
   **/
  public CasServerError getError() {
    return error;
  }

  /**
   * @param error
   * @return this
   **/
  public CasServerResult setError(CasServerError error) {
    this.error = error;
    return this;
  }
}
