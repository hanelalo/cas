package com.hanelalo.cas.server.service.impl;

import com.hanelalo.cas.server.base.TokenProcessorSupplier;
import com.hanelalo.cas.server.context.CasRequestContext;
import com.hanelalo.cas.server.service.CasHandlerRegistry;
import com.hanelalo.cas.server.service.TokenService;
import com.hanelalo.cas.server.service.core.AccessToken;
import com.hanelalo.cas.server.user.PasswordEncoder;
import com.hanelalo.cas.server.user.UserDetailService;
import com.hanelalo.cas.server.user.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

  @Autowired
  private UserDetailService userDetailService;
  @Autowired
  private TokenProcessorSupplier tokenProcessorSupplier;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private CasHandlerRegistry registry;

  @Override
  public AccessToken getAccessToken(String userId, String password) {
    preHandler();
    UserDetails details = userDetailService.loadUser(userId);
    passwordEncoder.valid(details.getPassword(),password);
    CasRequestContext.setLocalThreadValue(details);
    postHandler();
    return tokenProcessorSupplier.get().buildAccessToken(details);
  }

  private void postHandler() {
    registry.preExecute();
  }

  private void preHandler() {
    registry.postExecute();
  }
}
