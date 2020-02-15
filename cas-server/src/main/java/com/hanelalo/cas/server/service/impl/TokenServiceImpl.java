package com.hanelalo.cas.server.service.impl;

import com.hanelalo.cas.server.base.token.TokenProcessor;
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
  private TokenProcessor tokenProcessor;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public AccessToken getAccessToken(String userId, String password) {
    UserDetails details = userDetailService.loadUser(userId);
    passwordEncoder.valid(details.getPassword(),password);
    return tokenProcessor.buildAccessToken(details);
  }
}
