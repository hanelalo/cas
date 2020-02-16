package com.hanelalo.cas.client.client;

import com.hanelalo.cas.client.api.TokenInfoReq;
import com.hanelalo.cas.client.api.TokenInfoResp;

public interface CasServerInvoker {

  TokenInfoResp getTokenInfo(TokenInfoReq req);

}
