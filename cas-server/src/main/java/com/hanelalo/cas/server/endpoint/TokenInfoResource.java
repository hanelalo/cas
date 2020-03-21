package com.hanelalo.cas.server.endpoint;

import com.google.common.collect.Lists;
import com.hanelalo.cas.server.endpoint.api.AuthorityDto;
import com.hanelalo.cas.server.endpoint.api.TokenInfoReq;
import com.hanelalo.cas.server.endpoint.api.TokenInfoResp;
import com.hanelalo.cas.server.service.TokenInfoService;
import com.hanelalo.cas.server.service.core.TokenInfo;
import com.hanelalo.cas.server.user.Authority;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Token Info")
public class TokenInfoResource {

  @Autowired
  private TokenInfoService tokenInfoService;

  @ApiOperation("获取token信息")
  @PostMapping("token_info")
  public TokenInfoResp tokenInfo(@RequestBody @Valid TokenInfoReq tokenInfoReq) {
    return convert(tokenInfoService.tokenInfo(tokenInfoReq.getAccessToken()));
  }

  private TokenInfoResp convert(TokenInfo tokenInfo) {
    return new TokenInfoResp()
            .setClientId(tokenInfo.getClientId())
            .setUserId(tokenInfo.getUserId())
            .setAuthorities(getAuthorities(tokenInfo.getAuthorities()))
            .setCreateDate(tokenInfo.getCreateDate())
            .setValidTime(tokenInfo.getValidTime());
  }

  private List<AuthorityDto> getAuthorities(List<Authority> authorities) {
    if (CollectionUtils.isEmpty(authorities)) {
      return Lists.newArrayList();
    }
    return authorities.stream()
            .map(authority -> new AuthorityDto()
                    .setAuthorityKey(authority.getAuthorityKey())
                    .setAuthorityValue(authority.getAuthorityValue()))
            .collect(Collectors.toList());
  }
}
