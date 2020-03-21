package com.hanelalo.cas.client.web.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTestController {

  @PostMapping("test")
  public String test(){
    return "success";
  }

}
