package com.hanelalo.cas.server.endpoint;

import com.hanelalo.cas.server.base.CasServerResult;
import com.hanelalo.cas.server.endpoint.api.TokenInfoReq;
import com.hanelalo.cas.server.endpoint.api.TokenInfoResp;
import com.hanelalo.cas.server.service.TokenInfoService;
import com.hanelalo.cas.server.service.core.TokenInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Token Info")
public class TokenInfoResource {

  @Autowired
  private TokenInfoService tokenInfoService;

  @ApiOperation("获取token信息")
  @PostMapping("token_info")
  public CasServerResult<TokenInfoResp> tokenInfo(@RequestBody @Valid TokenInfoReq tokenInfoReq) {
    return convert(tokenInfoService.tokenInfo(tokenInfoReq.getAccessToken()));
  }

  private CasServerResult<TokenInfoResp> convert(TokenInfo tokenInfo) {
    TokenInfoResp resp = new TokenInfoResp()
        .setClientId(tokenInfo.getClientId())
        .setUserId(tokenInfo.getUserId())
        .setRoles(tokenInfo.getRoles())
        .setCreateDate(tokenInfo.getCreateDate())
        .setValidTime(tokenInfo.getValidTime());
    return new CasServerResult<TokenInfoResp>()
        .setResult(resp);
  }
}
