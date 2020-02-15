package com.hanelalo.cas.server.user;

public interface PasswordEncoder {

  String encode(String password);
  void valid(String resource,String password);

}
