package com.hanelalo.cas.server.user.impl;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.hanelalo.cas.server.base.exception.CasServerException;
import com.hanelalo.cas.server.base.exception.CasServerExceptionEnum;
import com.hanelalo.cas.server.user.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Sha256PasswordEncoder implements PasswordEncoder {

  private static HashFunction sha = Hashing.sha256();

  @Override
  public String encode(String password) {
    return sha.hashBytes(password.getBytes()).toString();
  }

  @Override
  public void valid(String resource, String password) {
    String validPass = sha.hashBytes(password.getBytes()).toString();
    if(!resource.equals(validPass)){
      throw new CasServerException(CasServerExceptionEnum.USER_INVALID.getErrorCode(),
          CasServerExceptionEnum.USER_INVALID.getErrorMsg());
    }
  }
}
