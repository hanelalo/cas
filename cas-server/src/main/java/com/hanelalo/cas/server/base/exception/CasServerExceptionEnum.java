package com.hanelalo.cas.server.base.exception;

public enum CasServerExceptionEnum {

  CLIENT_ERROR("CS_0001","client is invalid"),
  USER_INVALID("CS_0002","username or password is invalid"),
  UNKNOWN("CS_0003","server error"),
  TOKEN_INVALID("CS_0004","token is invalid"),
  REFRESH_TOKEN_INVALID("CS_0005","refresh token is invalid");

  private String errorCode;
  private String errorMsg;

  CasServerExceptionEnum(String errorCode, String errorMsg) {
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }
}
