package com.hanelalo.cas.client.client;

import com.hanelalo.cas.client.annotation.AuthorityPair;
import com.hanelalo.cas.client.api.TokenInfoReq;
import com.hanelalo.cas.client.api.TokenInfoResp;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorityProcessor {

  @Autowired
  private CasServerInvoker casServerInvoker;
  @Autowired
  private TokenChecker checker;



  public void authorization(String authorization, List<AuthorityPair> authorityPairs) {
    TokenInfoResp result = casServerInvoker
            .getTokenInfo(new TokenInfoReq().setAccessToken(authorization));
    checker.checkToken(result,authorityPairs);
  }
}
