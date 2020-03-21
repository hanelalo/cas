package com.hanelalo.cas.client.client;

import com.hanelalo.cas.client.api.TokenInfoReq;
import com.hanelalo.cas.client.api.TokenInfoResp;
import com.hanelalo.cas.client.config.CasClientProperties;
import com.hanelalo.cas.client.exception.PropertiesPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.jwt.codec.Codecs;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class CasServerRestInvoker implements CasServerInvoker {
  @Autowired
  private CasClientProperties properties;
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public TokenInfoResp getTokenInfo(TokenInfoReq req) {
    PropertiesPreconditions.checkClientProperties();
    MultiValueMap<String, String> headers = buildHeaders();
    return getTokenInfoResp(req, headers);
  }

  private TokenInfoResp getTokenInfoResp(TokenInfoReq req, MultiValueMap<String, String> headers) {
    HttpEntity<TokenInfoReq> entity = new HttpEntity<>(req, headers);
    return restTemplate.postForEntity(properties.getTokenInfoPath(), entity,
        TokenInfoResp.class).getBody();
  }

  private MultiValueMap<String, String> buildHeaders() {
    String clientId = properties.getClientId();
    String clientSecret = properties.getClientSecret();
    String authorization = new String(Codecs.b64Encode((clientId + ":" + clientSecret).getBytes()));
    MultiValueMap<String, String> headers = new LinkedMultiValueMap();
    headers.add("Authorization", "Bearer " + authorization);
    return headers;
  }

}
