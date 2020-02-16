package com.hanelalo.cas.client.exception;

public class CasClientException extends RuntimeException{
  private static final long serialVersionUID = -1543961537348608650L;
  private String errorCode;
  private String errorMsg;

  public CasClientException(String errorCode, String errorMsg) {
    super(errorMsg);
    this.errorCode = errorCode;
    this.errorMsg = errorMsg;
  }

  public CasClientException(CasClientExceptionEnum exceptionEnum){
    this(exceptionEnum.getErrorCode(),exceptionEnum.getErrorMsg());
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
  public CasClientException setErrorCode(String errorCode) {
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
  public CasClientException setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }
}
