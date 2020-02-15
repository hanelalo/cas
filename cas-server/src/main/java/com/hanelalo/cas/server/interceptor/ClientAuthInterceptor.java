package com.hanelalo.cas.server.interceptor;

import com.google.common.base.Strings;
import com.hanelalo.cas.server.base.exception.CasServerException;
import com.hanelalo.cas.server.base.exception.CasServerExceptionEnum;
import com.hanelalo.cas.server.client.ClientDetails;
import com.hanelalo.cas.server.context.CasApplicationContext;
import com.hanelalo.cas.server.context.CasRequestContext;
import com.hanelalo.cas.server.redis.RedisOperator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class ClientAuthInterceptor implements HandlerInterceptor {

  ///打印日志
  private static final Logger logger = LoggerFactory.getLogger(ClientAuthInterceptor.class);

  private static String AUTHORIZATION_TYPE = "Bearer ";

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    String authorization = request.getHeader("Authorization");
    if (Strings.isNullOrEmpty(authorization)
        || !authorization.startsWith(AUTHORIZATION_TYPE)) {
      logger.error("客户端校验失败，缺失 Authorization 请求头");
      throw new CasServerException(CasServerExceptionEnum.CLIENT_ERROR.getErrorCode(),
          CasServerExceptionEnum.CLIENT_ERROR.getErrorMsg());
    }

    authorization = authorization.replace(AUTHORIZATION_TYPE,"");

    ClientDetails clientDetails = getClientDetailsInRedis(authorization);
    CasRequestContext.setLocalThreadValue(clientDetails);
    return true;
  }

  private ClientDetails getClientDetailsInRedis(String authorization) {
    RedisOperator redisOperator = CasApplicationContext.getBean(RedisOperator.class);
    ClientDetails details = redisOperator.getClientDetails(authorization);
    if (details == null) {
      logger.error("客户端校验失败，未找到改客户端{}",authorization);
      throw new CasServerException(CasServerExceptionEnum.CLIENT_ERROR.getErrorCode(),
          CasServerExceptionEnum.CLIENT_ERROR.getErrorMsg());
    }
    return details;
  }
}
