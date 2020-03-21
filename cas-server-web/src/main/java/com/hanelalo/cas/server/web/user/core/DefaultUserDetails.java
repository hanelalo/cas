package com.hanelalo.cas.server.web.user.core;

import com.hanelalo.cas.server.user.Authority;
import com.hanelalo.cas.server.user.UserDetails;

import java.util.List;

public class DefaultUserDetails implements UserDetails {

  private String userId;
  private String password;
  private String username;
  private List<Authority> authorities;

  @Override
  public String getUserId() {
    return userId;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public List<Authority> getAuthorities() {
    return authorities;
  }

  @Override
  public boolean getValid() {
    return false;
  }

  public DefaultUserDetails setUserId(String userId) {
    this.userId = userId;
    return this;
  }

  public DefaultUserDetails setPassword(String password) {
    this.password = password;
    return this;
  }


  public String getUsername() {
    return username;
  }

  public DefaultUserDetails setUsername(String username) {
    this.username = username;
    return this;
  }

  /**
   * @param authorities authorities
   * @return this
   **/
  public DefaultUserDetails setAuthorities(List<Authority> authorities) {
    this.authorities = authorities;
    return this;
  }
}
