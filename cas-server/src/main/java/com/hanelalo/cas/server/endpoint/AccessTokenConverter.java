package com.hanelalo.cas.server.endpoint;

import com.hanelalo.cas.server.endpoint.api.AccessTokenResp;
import com.hanelalo.cas.server.endpoint.api.RefreshToken;
import com.hanelalo.cas.server.service.core.AccessToken;

public class AccessTokenConverter{

  public static AccessTokenResp convert(AccessToken accessToken){
    RefreshToken refreshToken = new RefreshToken()
        .setRefreshToken(accessToken.getRefreshToken());
    return new AccessTokenResp()
        .setUser(accessToken.getUser())
        .setAccessToken(accessToken.getAccessToken())
        .setRefreshToken(refreshToken)
        .setJti(accessToken.getJti());
  }

}
