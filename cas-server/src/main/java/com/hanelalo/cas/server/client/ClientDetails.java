package com.hanelalo.cas.server.client;


import java.io.Serializable;

public class ClientDetails implements Serializable {

  private static final long serialVersionUID = 4913239020566615068L;
  private String clientId;
  private String clientSecret;
  private String grantType;
  private String valid;

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
  public ClientDetails setClientId(String clientId) {
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
  public ClientDetails setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  /**
   * Get grantType
   **/
  public String getGrantType() {
    return grantType;
  }

  /**
   * @param grantType
   * @return this
   **/
  public ClientDetails setGrantType(String grantType) {
    this.grantType = grantType;
    return this;
  }

  /**
   * Get valid
   **/
  public String getValid() {
    return valid;
  }

  /**
   * @param valid
   * @return this
   **/
  public ClientDetails setValid(String valid) {
    this.valid = valid;
    return this;
  }
}
