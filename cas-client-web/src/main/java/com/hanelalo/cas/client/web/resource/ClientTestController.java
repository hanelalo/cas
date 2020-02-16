package com.hanelalo.cas.client.web.resource;

import com.hanelalo.cas.client.annotation.ModeEnum;
import com.hanelalo.cas.client.annotation.RoleAccess;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientTestController {

  @RoleAccess(roles = {"ADMIN"},
      mode = ModeEnum.OR)
  @PostMapping("test")
  public String test(){
    return "success";
  }

}
