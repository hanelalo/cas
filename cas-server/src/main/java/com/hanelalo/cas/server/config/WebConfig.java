package com.hanelalo.cas.server.config;

import com.hanelalo.cas.server.interceptor.ClientAuthInterceptor;
import com.hanelalo.cas.server.service.CasHandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  private CasServerConfigurer casServerConfigurer;
  @Autowired
  private CasHandlerRegistry casHandlerRegistry;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(new ClientAuthInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/registerClient", "/swagger-ui.html", "/swagger-ui.html/**",
            "/swagger-resources/**", "/v2/**", "/swagger-ui.html#!/**", "/webjars/**",
            "/swagger-resources/**");
    casServerConfigurer.addHandler(casHandlerRegistry);
  }

}