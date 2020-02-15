package com.hanelalo.cas.server.user.core;

import com.hanelalo.cas.server.user.RoleType;
import com.hanelalo.cas.server.user.UserDetails;
import java.util.Collection;
import java.util.List;

public class DefaultUserDetails implements UserDetails {

  private String userId;
  private String password;
  private String username;
  private List<DefaultRole> roles;

  @Override
  public String getUserId() {
    return userId;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends RoleType> getRoles() {
    return roles;
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

  public DefaultUserDetails setRoles(List<DefaultRole> roles) {
    this.roles = roles;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public DefaultUserDetails setUsername(String username) {
    this.username = username;
    return this;
  }
}
