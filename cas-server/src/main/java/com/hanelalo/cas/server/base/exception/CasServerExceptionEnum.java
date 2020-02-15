package com.hanelalo.cas.server.base.exception;

public enum CasServerExceptionEnum {

  CLIENT_ERROR("CS_0001","客户端校验错误"),
  USER_INVALID("CS_0002","用户名或密码错误"),
  UNKNOWN("CS_0003","服务器错误"),
  TOKEN_INVALID("CS_0004","Token 已过期"),
  REFRESH_TOKEN_INVALID("CS_0004","Refresh Token 已过期");

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
