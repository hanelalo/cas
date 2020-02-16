package com.hanelalo.cas.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
    prefix = "mall.auth",
    ignoreInvalidFields = true)
public class AuthServerProperties {

  private String publicKeyResourcePath = "rsa_public_key.pem";
  private String privateKeyResourcePath = "rsa_private_key.pem";
  private String clientTable = "cas_client_details";
  private boolean swaggerEnable = false;
  private long validTime = 2592000L;
  private String[] interceptorUrl = new String[]{"/**"};
  private String[] interceptorExcludeUrl = new String[]{"/registerClient", "/swagger-ui.html", "/swagger-ui.html/**",
      "/swagger-resources/**", "/v2/**", "/swagger-ui.html#!/**", "/webjars/**",
      "/swagger-resources/**"};

  public String getPublicKeyResourcePath() {
    return publicKeyResourcePath;
  }

  public void setPublicKeyResourcePath(String publicKeyResourcePath) {
    this.publicKeyResourcePath = publicKeyResourcePath;
  }

  public String getPrivateKeyResourcePath() {
    return privateKeyResourcePath;
  }

  public void setPrivateKeyResourcePath(String privateKeyResourcePath) {
    this.privateKeyResourcePath = privateKeyResourcePath;
  }

  public String getClientTable() {
    return clientTable;
  }

  public void setClientTable(String clientTable) {
    this.clientTable = clientTable;
  }

  public boolean isSwaggerEnable() {
    return swaggerEnable;
  }

  public void setSwaggerEnable(boolean swaggerEnable) {
    this.swaggerEnable = swaggerEnable;
  }

  public long getValidTime() {
    return validTime;
  }

  public void setValidTime(long validTime) {
    this.validTime = validTime;
  }

  public String[] getInterceptorUrl() {
    return interceptorUrl;
  }

  public void setInterceptorUrl(String[] interceptorUrl) {
    this.interceptorUrl = interceptorUrl;
  }

  public String[] getInterceptorExcludeUrl() {
    return interceptorExcludeUrl;
  }

  public void setInterceptorExcludeUrl(String[] interceptorExcludeUrl) {
    this.interceptorExcludeUrl = interceptorExcludeUrl;
  }
}
