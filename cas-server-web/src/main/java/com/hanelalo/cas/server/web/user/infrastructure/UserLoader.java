package com.hanelalo.cas.server.web.user.infrastructure;

public interface UserLoader {
  User load(String userId);
}
