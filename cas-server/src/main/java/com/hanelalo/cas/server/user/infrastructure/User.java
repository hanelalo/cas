package com.hanelalo.cas.server.user.infrastructure;

public class User {

  private String userId;
  private String username;
  private String password;
  private String valid;
  private String roles;

  /**
   * Get userId
   **/
  public String getUserId() {
    return userId;
  }

  /**
   * @param userId
   * @return this
   **/
  public User setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get username
   **/
  public String getUsername() {
    return username;
  }

  /**
   * @param username
   * @return this
   **/
  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get password
   **/
  public String getPassword() {
    return password;
  }

  /**
   * @param password
   * @return this
   **/
  public User setPassword(String password) {
    this.password = password;
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
  public User setValid(String valid) {
    this.valid = valid;
    return this;
  }

  /**
   * Get roles
   **/
  public String getRoles() {
    return roles;
  }

  /**
   * @param roles
   * @return this
   **/
  public User setRoles(String roles) {
    this.roles = roles;
    return this;
  }
}
