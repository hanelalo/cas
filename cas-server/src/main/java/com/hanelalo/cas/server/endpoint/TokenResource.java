package com.hanelalo.cas.server.endpoint;

import com.hanelalo.cas.server.endpoint.api.AccessTokenReq;
import com.hanelalo.cas.server.endpoint.api.AccessTokenResp;
import com.hanelalo.cas.server.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("auth")
@Api(tags = "Token", produces = "application/json")
public class TokenResource {

  @Autowired
  private TokenService tokenService;

  @ApiOperation("生成Token")
  @PostMapping("token")
  public AccessTokenResp token(@RequestBody @Valid AccessTokenReq accessTokenReq) {
    return AccessTokenConverter.convert((tokenService.getAccessToken(
        accessTokenReq.getUserId(),
        accessTokenReq.getPassword())));
  }
}
