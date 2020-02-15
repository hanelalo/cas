package com.hanelalo.cas.server.endpoint;

import com.hanelalo.cas.server.base.CasServerResult;
import com.hanelalo.cas.server.endpoint.api.AccessTokenResp;
import com.hanelalo.cas.server.endpoint.api.RefreshTokenReq;
import com.hanelalo.cas.server.service.RefreshTokenService;
import com.hanelalo.cas.server.service.core.AccessToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Refresh Token")
@RestController
public class RefreshTokenResource {

  @Autowired
  private RefreshTokenService refreshTokenService;

  @PostMapping("refresh_token")
  @ApiOperation("刷新 token")
  public CasServerResult<AccessTokenResp> refresh(
      @RequestBody @Valid RefreshTokenReq refreshTokenReq) {
    return convert(refreshTokenService.refreshToken(refreshTokenReq.getRefreshToken()));
  }

  private CasServerResult<AccessTokenResp> convert(AccessToken token) {
    CasServerResult<AccessTokenResp> result = new CasServerResult<>();
    result.setResult(AccessTokenConverter.convert(token));
    return result;
  }

}
