package com.hanelalo.cas.server.service;

import com.hanelalo.cas.server.service.core.TokenInfo;

public interface TokenInfoService {
  TokenInfo tokenInfo(String token);
}
