package com.hanelalo.cas.server.user;

public interface UserDetailService {

  UserDetails loadUser(String userId);

}
