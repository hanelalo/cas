package com.hanelalo.cas.client.client;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.hanelalo.cas.client.annotation.ModeEnum;
import com.hanelalo.cas.client.api.TokenInfoResp;
import com.hanelalo.cas.client.exception.CasClientPreconditions;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class TokenChecker {

  private static String CS_0001 = "CS_0001";
  private static String CS_0003 = "CS_0003";
  private static String CS_0004 = "CS_0004";

  public void checkToken(TokenInfoResp result, List<String> roles, ModeEnum mode) {
    chechError(result);
    String authRoles = Joiner.on(",").skipNulls().join(result.getRoles());
    CasClientPreconditions.checkTokenPermission(!Strings.isNullOrEmpty(authRoles));
    roles = roles.stream().distinct().collect(Collectors.toList());
    if (mode.equals(ModeEnum.AND)) {
      computeRoleModeAND(authRoles, roles);
    } else if (mode.equals(ModeEnum.NOT)) {
      computeRoleModeNOT(authRoles, roles);
    } else {
      computeRoleModeOR(authRoles, roles);
    }
  }

  private void chechError(TokenInfoResp result) {
    if (result.getError() != null) {
      CasClientPreconditions.checkClientInvalid(!CS_0001.equals(result.getError().getErrorCode()));
      CasClientPreconditions.checkServerError(!CS_0003.equals(result.getError().getErrorCode()));
      CasClientPreconditions.checkTokenInvalid(!CS_0004.equals(result.getError().getErrorCode()));
    }
  }

  private void computeRoleModeNOT(String authRoles, List<String> roles) {
    roles.forEach(role -> {
      CasClientPreconditions.checkTokenPermission(!authRoles.contains(role));
    });
  }

  private void computeRoleModeAND(String authRoles, List<String> roles) {
    List<String> collect = roles.stream().filter(authRoles::contains)
        .collect(Collectors.toList());
    CasClientPreconditions.checkTokenPermission(collect.size() == roles.size());
  }

  private void computeRoleModeOR(String authRoles, List<String> roles) {
    List<String> collect = roles.stream().filter(authRoles::contains)
        .collect(Collectors.toList());
    CasClientPreconditions.checkTokenPermission(collect.size() > 0);
  }
}
