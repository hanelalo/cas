package com.hanelalo.cas.client.config;

import com.hanelalo.cas.client.exception.PropertiesPreconditions;
import javax.annotation.PostConstruct;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "cas.client", ignoreInvalidFields = true)
public class CasClientProperties {
  private String clientId;
  private String clientSecret;
  private String tokenPath;
  private String tokenInfoPath;
  private String refreshTokenPath;

  @PostConstruct
  public void checkProperties(){
    PropertiesPreconditions.checkClientProperties(this);
  }

  /**
   * Get clientId
   **/
  public String getClientId() {
    return clientId;
  }

  /**
   * @param clientId
   * @return this
   **/
  public CasClientProperties setClientId(String clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Get clientSecret
   **/
  public String getClientSecret() {
    return clientSecret;
  }

  /**
   * @param clientSecret
   * @return this
   **/
  public CasClientProperties setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  /**
   * Get tokenPath
   **/
  public String getTokenPath() {
    return tokenPath;
  }

  /**
   * @param tokenPath
   * @return this
   **/
  public CasClientProperties setTokenPath(String tokenPath) {
    this.tokenPath = tokenPath;
    return this;
  }

  /**
   * Get tokenInfoPath
   **/
  public String getTokenInfoPath() {
    return tokenInfoPath;
  }

  /**
   * @param tokenInfoPath
   * @return this
   **/
  public CasClientProperties setTokenInfoPath(String tokenInfoPath) {
    this.tokenInfoPath = tokenInfoPath;
    return this;
  }

  /**
   * Get refreshTokenPath
   **/
  public String getRefreshTokenPath() {
    return refreshTokenPath;
  }

  /**
   * @param refreshTokenPath
   * @return this
   **/
  public CasClientProperties setRefreshTokenPath(String refreshTokenPath) {
    this.refreshTokenPath = refreshTokenPath;
    return this;
  }
}
