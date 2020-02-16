package com.hanelalo.cas.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(
    prefix = "cas.server",
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

  /**
   * Get publicKeyResourcePath
   **/
  public String getPublicKeyResourcePath() {
    return publicKeyResourcePath;
  }

  /**
   * @param publicKeyResourcePath
   * @return this
   **/
  public AuthServerProperties setPublicKeyResourcePath(String publicKeyResourcePath) {
    this.publicKeyResourcePath = publicKeyResourcePath;
    return this;
  }

  /**
   * Get privateKeyResourcePath
   **/
  public String getPrivateKeyResourcePath() {
    return privateKeyResourcePath;
  }

  /**
   * @param privateKeyResourcePath
   * @return this
   **/
  public AuthServerProperties setPrivateKeyResourcePath(String privateKeyResourcePath) {
    this.privateKeyResourcePath = privateKeyResourcePath;
    return this;
  }

  /**
   * Get clientTable
   **/
  public String getClientTable() {
    return clientTable;
  }

  /**
   * @param clientTable
   * @return this
   **/
  public AuthServerProperties setClientTable(String clientTable) {
    this.clientTable = clientTable;
    return this;
  }

  /**
   * Get swaggerEnable
   **/
  public boolean isSwaggerEnable() {
    return swaggerEnable;
  }

  /**
   * @param swaggerEnable
   * @return this
   **/
  public AuthServerProperties setSwaggerEnable(boolean swaggerEnable) {
    this.swaggerEnable = swaggerEnable;
    return this;
  }

  /**
   * Get validTime
   **/
  public long getValidTime() {
    return validTime;
  }

  /**
   * @param validTime
   * @return this
   **/
  public AuthServerProperties setValidTime(long validTime) {
    this.validTime = validTime;
    return this;
  }

  /**
   * Get interceptorUrl
   **/
  public String[] getInterceptorUrl() {
    return interceptorUrl;
  }

  /**
   * @param interceptorUrl
   * @return this
   **/
  public AuthServerProperties setInterceptorUrl(String[] interceptorUrl) {
    this.interceptorUrl = interceptorUrl;
    return this;
  }

  /**
   * Get interceptorExcludeUrl
   **/
  public String[] getInterceptorExcludeUrl() {
    return interceptorExcludeUrl;
  }

  /**
   * @param interceptorExcludeUrl
   * @return this
   **/
  public AuthServerProperties setInterceptorExcludeUrl(String[] interceptorExcludeUrl) {
    this.interceptorExcludeUrl = interceptorExcludeUrl;
    return this;
  }
}
