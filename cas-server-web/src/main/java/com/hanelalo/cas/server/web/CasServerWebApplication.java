package com.hanelalo.cas.server.web;

import com.hanelalo.cas.server.EnableCasServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasServer
public class CasServerWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(CasServerWebApplication.class, args);
  }
}
