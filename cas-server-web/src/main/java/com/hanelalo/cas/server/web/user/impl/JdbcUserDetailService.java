package com.hanelalo.cas.server.web.user.impl;

import com.hanelalo.cas.server.client.ClientPoint;
import com.hanelalo.cas.server.user.UserDetailService;
import com.hanelalo.cas.server.user.UserDetails;
import com.hanelalo.cas.server.web.user.core.DefaultUserDetails;
import com.hanelalo.cas.server.web.user.infrastructure.User;
import com.hanelalo.cas.server.web.user.infrastructure.UserLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ClientPoint(clientId = "948fe603f61dc036b5c596dc09fe3ce3f3d30dc90f024c85f3c82db2ccab679d")
public class JdbcUserDetailService implements UserDetailService {

  @Autowired
  private UserLoader loader;

  @Override
  public UserDetails loadUser(String userId) {
    User user = loader.load(userId);
    return convert(user);
  }

  private UserDetails convert(User user) {
    DefaultUserDetails details = new DefaultUserDetails();

    return details
        .setUserId(user.getUserId())
        .setPassword(user.getPassword())
        .setUsername(user.getUsername());
  }
}
