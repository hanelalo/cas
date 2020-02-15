package com.hanelalo.cas.server.user.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.hanelalo.cas.server.user.core.DefaultRole;
import com.hanelalo.cas.server.user.core.DefaultUserDetails;
import com.hanelalo.cas.server.user.infrastructure.User;
import com.hanelalo.cas.server.user.UserDetailService;
import com.hanelalo.cas.server.user.UserDetails;
import com.hanelalo.cas.server.user.infrastructure.UserLoader;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
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

    List<DefaultRole> roles = Splitter
        .on(",").splitToList(user.getRoles())
        .stream().map(role -> new DefaultRole().setRole(role))
        .collect(Collectors.toList());
    return details
        .setUserId(user.getUserId())
        .setPassword(user.getPassword())
        .setUsername(user.getUsername())
        .setRoles(roles);
  }
}
