package com.hanelalo.cas.client.exception;

import org.omg.CORBA.NO_PERMISSION;

public enum CasClientExceptionEnum {

  NO_PERMISSION("CC_0001", "no permission"),
  TOKEN_INVALID("CC_0002", "token is invalid"),
  CLIENT_INVALID("CC_0003", "client is invalid"),
  SERVER_ERROR("CC_0004", "server error"),
  NULL_TOKEN("CC_0005","token is null"),
  NULL_PROPERTY_SET("CC_0006",
      "properties must set,please view class @CasClientProperties");
  private String errorCode;
  private String errorMsg;

  CasClientExceptionEnum(String errorCode, String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  /**
   * Get errorCode
   **/
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * @param errorCode
   * @return this
   **/
  public CasClientExceptionEnum setErrorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * Get errorMsg
   **/
  public String getErrorMsg() {
    return errorMsg;
  }

  /**
   * @param errorMsg
   * @return this
   **/
  public CasClientExceptionEnum setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }
}
