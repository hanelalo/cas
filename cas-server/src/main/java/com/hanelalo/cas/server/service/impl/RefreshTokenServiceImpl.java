package com.hanelalo.cas.server.service.impl;

import com.hanelalo.cas.server.base.TokenProcessorSupplier;
import com.hanelalo.cas.server.base.UserDetailsServiceSupplier;
import com.hanelalo.cas.server.base.exception.CasServerPreconditions;
import com.hanelalo.cas.server.base.token.Payload;
import com.hanelalo.cas.server.config.AuthServerProperties;
import com.hanelalo.cas.server.service.CasHandlerRegistry;
import com.hanelalo.cas.server.service.RefreshTokenService;
import com.hanelalo.cas.server.service.core.AccessToken;
import com.hanelalo.cas.server.user.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {

  private final TokenProcessorSupplier tokenProcessorSupplier;
  private final UserDetailsServiceSupplier userDetailsServiceSupplier;
  private final AuthServerProperties properties;
  private final CasHandlerRegistry casHandlerRegistry;

  public RefreshTokenServiceImpl(CasHandlerRegistry casHandlerRegistry, AuthServerProperties properties,
                                 TokenProcessorSupplier tokenProcessorSupplier,
                                 UserDetailsServiceSupplier userDetailsServiceSupplier) {
    this.casHandlerRegistry = casHandlerRegistry;
    this.properties = properties;
    this.tokenProcessorSupplier = tokenProcessorSupplier;
    this.userDetailsServiceSupplier = userDetailsServiceSupplier;
  }

  @Override
  public AccessToken refreshToken(String refreshToken) {
    preHandle();
    Payload payload = tokenProcessorSupplier.get().readPayload(refreshToken);
    checkToken(payload);
    UserDetails userDetails = userDetailsServiceSupplier.get().loadUser(payload.getUserId());
    postHandle();
    return tokenProcessorSupplier.get().buildAccessToken(userDetails);
  }

  private void postHandle() {
    casHandlerRegistry.postExecute();
  }

  private void preHandle() {
    casHandlerRegistry.preExecute();
  }

  private void checkToken(Payload payload) {
    long createDate = payload.getCreateDate();
    long validTime = properties.getValidTime();
    CasServerPreconditions
        .checkRefreshTokenInvalid(createDate + validTime > System.currentTimeMillis());
  }
}
