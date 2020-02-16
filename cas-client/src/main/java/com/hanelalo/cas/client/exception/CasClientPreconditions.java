package com.hanelalo.cas.client.exception;

public class CasClientPreconditions {

  /**
   * CC_0001
   * @param expression
   */
  public static void checkTokenPermission(boolean expression){
    if(!expression){
      throw new CasClientException(CasClientExceptionEnum.NO_PERMISSION);
    }
  }

  /**
   * CC_0002
   * @param expression
   */
  public static void checkTokenInvalid(boolean expression){
    if(!expression){
      throw new CasClientException(CasClientExceptionEnum.TOKEN_INVALID.getErrorCode(),
          CasClientExceptionEnum.TOKEN_INVALID.getErrorMsg());
    }
  }

  /**
   * CC_0003
   * @param expression
   */
  public static void checkClientInvalid(boolean expression){
    if(!expression){
      throw new CasClientException(CasClientExceptionEnum.CLIENT_INVALID);
    }
  }

  /**
   * CC_0004
   * @param expression
   */
  public static void checkServerError(boolean expression){
    if(!expression){
      throw new CasClientException(CasClientExceptionEnum.SERVER_ERROR);
    }
  }

  /**
   * CC_0005
   * @param expression
   */
  public static void checkNullToken(boolean expression) {
    if(!expression){
      throw new CasClientException(CasClientExceptionEnum.NULL_TOKEN);
    }
  }
}
