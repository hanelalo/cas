package com.hanelalo.cas.server.base.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CasServerPreconditions {

  private static final Logger logger = LoggerFactory.getLogger(CasServerPreconditions.class);

  public static void checkClientError(boolean expression){
    if(!expression){
      logger.error("client valid error,please check your request param");
      throw new CasServerException(CasServerExceptionEnum.CLIENT_ERROR);
    }
  }

  public static void checkRefreshTokenInvalid(boolean expression) {
    if(!expression){
      logger.error("refresh token invalid");
      throw new CasServerException(CasServerExceptionEnum.REFRESH_TOKEN_INVALID);
    }
  }

  public static void checkTokenInvalid(boolean expression) {
    if(!expression){
      logger.error("token invalid");
      throw new CasServerException(CasServerExceptionEnum.TOKEN_INVALID);
    }
  }

  public static void checkUserInvalid(boolean expression) {
    if(!expression){
      logger.error("username or password is invalid");
      throw new CasServerException(CasServerExceptionEnum.USER_INVALID);
    }
  }
}
