package com.hanelalo.cas.server.web.user.core;

import com.hanelalo.cas.server.user.Authority;

public class DefaultAuthority implements Authority {

  private String authorityKey;
  private String authorityValue;

  @Override
  public String getAuthorityKey() {
    return authorityKey;
  }

  @Override
  public String getAuthorityValue() {
    return authorityValue;
  }

  public DefaultAuthority setAuthorityKey(String authorityKey) {
    this.authorityKey = authorityKey;
    return this;
  }

  public DefaultAuthority setAuthorityValue(String authorityValue) {
    this.authorityValue = authorityValue;
    return this;
  }
}
