package com.hanelalo.cas.server.base.exception;

public class CasServerException extends RuntimeException {
  private static final long serialVersionUID = 9210041423331283968L;

  private String errorCode;
  private String errorMsg;

  public CasServerException(String errorCode,String errorMsg){
    super(errorMsg);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public CasServerException(CasServerExceptionEnum exceptionEnum){
    this(exceptionEnum.getErrorCode(),exceptionEnum.getErrorMsg());
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
