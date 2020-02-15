package com.hanelalo.cas.server.base.exception;

import com.hanelalo.cas.server.base.CasServerError;
import com.hanelalo.cas.server.base.CasServerResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public CasServerResult handle(Exception e) {
    CasServerResult result = new CasServerResult();
    if (e instanceof CasServerException) {
      CasServerException exception = (CasServerException) e;
      CasServerError error = new CasServerError().setErrorCode(exception.getErrorCode())
          .setErrorMsg(exception.getErrorMsg());
      result.setError(error);
    } else {
      CasServerError error = new CasServerError()
          .setErrorCode(CasServerExceptionEnum.UNKNOWN.getErrorCode())
          .setErrorMsg(CasServerExceptionEnum.UNKNOWN.getErrorMsg());
      result.setError(error);
    }
    return result;
  }
}
