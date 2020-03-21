package com.hanelalo.cas.server.user;

import java.util.List;

public interface UserDetails {
  String getUserId();
  String getPassword();
  List<Authority> getAuthorities();
  boolean getValid();
}
