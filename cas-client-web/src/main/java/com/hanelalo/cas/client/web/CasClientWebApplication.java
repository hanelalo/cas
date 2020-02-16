package com.hanelalo.cas.client.web;

import com.hanelalo.cas.client.EnableCasClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableCasClient
public class CasClientWebApplication {

  public static void main(String[] args) {
    SpringApplication.run(CasClientWebApplication.class, args);
  }

}
