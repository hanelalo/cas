package com.hanelalo.cas.server.config;

import com.hanelalo.cas.server.interceptor.ClientAuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        .addInterceptor(new ClientAuthInterceptor())
        .addPathPatterns("/**")
        .excludePathPatterns("/registerClient", "/swagger-ui.html", "/swagger-ui.html/**",
            "/swagger-resources/**", "/v2/**", "/swagger-ui.html#!/**", "/webjars/**",
            "/swagger-resources/**");
  }

}