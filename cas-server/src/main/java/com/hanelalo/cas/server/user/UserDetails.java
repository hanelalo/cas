package com.hanelalo.cas.server.user;

import java.util.Collection;
import java.util.List;

public interface UserDetails {
  String getUserId();
  String getPassword();
  Collection<? extends RoleType> getRoles();
  boolean getValid();
}
