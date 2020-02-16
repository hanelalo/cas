package com.hanelalo.cas.server;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1000)
@ComponentScan(basePackageClasses = CasServerConfig.class)
public class CasServerConfig {

}
