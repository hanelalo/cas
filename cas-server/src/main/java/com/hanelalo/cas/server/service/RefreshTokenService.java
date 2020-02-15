package com.hanelalo.cas.server.service;

import com.hanelalo.cas.server.service.core.AccessToken;

public interface RefreshTokenService {
  AccessToken refreshToken(String refreshToken);
}
