package com.hanelalo.cas.client.aop;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.hanelalo.cas.client.annotation.ModeEnum;
import com.hanelalo.cas.client.annotation.RoleAccess;
import com.hanelalo.cas.client.client.RoleAccessProcessor;
import com.hanelalo.cas.client.exception.CasClientPreconditions;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RoleControlAspect {
  @Autowired
  private RoleAccessProcessor processor;
  @Autowired
  private HttpServletRequest httpServletRequest;

  @Pointcut("@annotation(com.hanelalo.cas.client.annotation.RoleAccess)")
  public void onAspectJ(){}

  @Before(value = "onAspectJ() && @annotation(roleAccess)")
  public void roleAccess(RoleAccess roleAccess){

    String authorization = httpServletRequest.getHeader("Authorization");
    CasClientPreconditions.checkNullToken(!Strings.isNullOrEmpty(authorization));
    List<String> roles = Lists.newArrayList(roleAccess.roles());

    ModeEnum mode = roleAccess.mode();

    processor.authorization(authorization,roles,mode);
  }
}
