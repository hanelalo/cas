package com.hanelalo.cas.server.service;

import com.hanelalo.cas.server.service.core.AccessToken;

public interface TokenService {

  AccessToken getAccessToken(String userId,String password);

}
