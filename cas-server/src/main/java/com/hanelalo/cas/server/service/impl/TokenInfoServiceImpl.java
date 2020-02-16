package com.hanelalo.cas.server.service.impl;

import com.hanelalo.cas.server.base.exception.CasServerPreconditions;
import com.hanelalo.cas.server.base.token.Payload;
import com.hanelalo.cas.server.base.exception.CasServerException;
import com.hanelalo.cas.server.base.exception.CasServerExceptionEnum;
import com.hanelalo.cas.server.base.token.TokenProcessor;
import com.hanelalo.cas.server.config.AuthServerProperties;
import com.hanelalo.cas.server.service.TokenInfoService;
import com.hanelalo.cas.server.service.core.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenInfoServiceImpl implements TokenInfoService {

  @Autowired
  private AuthServerProperties properties;

  @Autowired
  private TokenProcessor tokenProcessor;

  @Override
  public TokenInfo tokenInfo(String token) {
    Payload payload = tokenProcessor.readPayload(token);
    checkToken(payload);
    return convert2TokenInfo(payload);
  }

  private void checkToken(Payload payload) {
    long createDate = payload.getCreateDate();
    // 获取配置的token过期时间而不是在payload中的过期时间
    long validTime = properties.getValidTime();
    CasServerPreconditions.checkTokenInvalid(createDate + validTime > System.currentTimeMillis());
  }

  private TokenInfo convert2TokenInfo(Payload payload) {
    return new TokenInfo()
        .setClientId(payload.getClientId())
        .setCreateDate(payload.getCreateDate())
        .setValidTime(payload.getValidTime())
        .setRoles(payload.getRoles())
        .setUserId(payload.getUserId());
  }
}
