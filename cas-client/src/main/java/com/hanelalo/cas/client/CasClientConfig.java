package com.hanelalo.cas.client;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackageClasses = CasClientConfig.class)
public class CasClientConfig {

  @LoadBalanced
  @Bean
  public RestTemplate getRestTemplate(){
    return new RestTemplate();
  }

}
