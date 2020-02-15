package com.hanelalo.cas.server.user.infrastructure;

public interface UserLoader {
  User load(String userId);
}
