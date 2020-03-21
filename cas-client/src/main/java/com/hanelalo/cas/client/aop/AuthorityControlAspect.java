package com.hanelalo.cas.client.aop;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.hanelalo.cas.client.annotation.Authorities;
import com.hanelalo.cas.client.annotation.AuthorityPair;
import com.hanelalo.cas.client.client.AuthorityProcessor;
import com.hanelalo.cas.client.exception.CasClientPreconditions;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class AuthorityControlAspect {
  @Autowired
  private AuthorityProcessor processor;
  @Autowired
  private HttpServletRequest httpServletRequest;

  @Pointcut("@annotation(com.hanelalo.cas.client.annotation.Authorities)")
  public void onAspectJ(){}

  @Before(value = "onAspectJ() && @annotation(authorities)")
  public void roleAccess(Authorities authorities){

    String authorization = httpServletRequest.getHeader("Authorization");
    CasClientPreconditions.checkNullToken(!Strings.isNullOrEmpty(authorization));
    List<AuthorityPair> authorityPairs = Lists.newArrayList(authorities.value());



    processor.authorization(authorization,authorityPairs);
  }
}
