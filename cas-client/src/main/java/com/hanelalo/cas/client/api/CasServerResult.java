package com.hanelalo.cas.client.api;

import java.io.Serializable;

public class CasServerResult implements Serializable {

  private static final long serialVersionUID = 4772766299020524340L;

  public CasServerResult(){}

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
