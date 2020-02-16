package com.hanelalo.cas.server.service.impl;

import com.hanelalo.cas.server.base.exception.CasServerPreconditions;
import com.hanelalo.cas.server.base.token.Payload;
import com.hanelalo.cas.server.base.exception.CasServerException;
import com.hanelalo.cas.server.base.exception.CasServerExceptionEnum;
import com.hanelalo.cas.server.base.token.TokenProcessor;
import com.hanelalo.cas.server.config.AuthServerProperties;
import com.hanelalo.cas.server.service.RefreshTokenService;
import com.hanelalo.cas.server.service.core.AccessToken;
import com.hanelalo.cas.server.user.UserDetailService;
import com.hanelalo.cas.server.user.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

  @Autowired
  private TokenProcessor processor;
  @Autowired
  private UserDetailService userDetailService;
  @Autowired
  private AuthServerProperties properties;

  @Override
  public AccessToken refreshToken(String refreshToken) {
    Payload payload = processor.readPayload(refreshToken);
    checkToken(payload);
    UserDetails userDetails = userDetailService.loadUser(payload.getUserId());
    return processor.buildAccessToken(userDetails);
  }

  private void checkToken(Payload payload) {
    long createDate = payload.getCreateDate();
    long validTime = properties.getValidTime();
    CasServerPreconditions
        .checkRefreshTokenInvalid(createDate + validTime > System.currentTimeMillis());
  }
}
