package com.hanelalo.cas.server.base;


import java.io.Serializable;

public class CasServerError implements Serializable {

  private static final long serialVersionUID = -2588674420689446547L;
  private String errorCode;
  private String errorMsg;

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
  public CasServerError setErrorCode(String errorCode) {
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
  public CasServerError setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
    return this;
  }
}
