package com.hanelalo.cas.server.config;

import com.hanelalo.cas.server.service.CasHandlerRegistry;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(CasServerConfigurer.class)
public class DefaultCasServerConfigurer implements CasServerConfigurer{
  @Override
  public void addHandler(CasHandlerRegistry registry) {
  }
}
