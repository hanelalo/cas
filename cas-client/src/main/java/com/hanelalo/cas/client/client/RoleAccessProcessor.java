package com.hanelalo.cas.client.client;

import com.hanelalo.cas.client.annotation.ModeEnum;
import com.hanelalo.cas.client.api.CasServerResult;
import com.hanelalo.cas.client.api.TokenInfoReq;
import com.hanelalo.cas.client.api.TokenInfoResp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleAccessProcessor {

  @Autowired
  private CasServerInvoker casServerInvoker;
  @Autowired
  private TokenChecker checker;

  public void authorization(String token, List<String> roles, ModeEnum mode){
    TokenInfoResp result = casServerInvoker
        .getTokenInfo(new TokenInfoReq().setAccessToken(token));
    checker.checkToken(result,roles,mode);
  }



}
