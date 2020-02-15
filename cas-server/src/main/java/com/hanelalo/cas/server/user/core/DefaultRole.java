package com.hanelalo.cas.server.user.core;

import com.hanelalo.cas.server.user.RoleType;

public class DefaultRole implements RoleType {

  private String role;

  @Override
  public String getRole() {
    return role;
  }

  public DefaultRole setRole(String role){
    this.role = role;
    return this;
  }
}
