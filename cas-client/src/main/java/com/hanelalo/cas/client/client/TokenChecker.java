package com.hanelalo.cas.client.client;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.hanelalo.cas.client.annotation.AuthorityPair;
import com.hanelalo.cas.client.api.Authority;
import com.hanelalo.cas.client.api.TokenInfoResp;
import com.hanelalo.cas.client.exception.CasClientPreconditions;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TokenChecker {

    private static String CS_0001 = "CS_0001";
    private static String CS_0003 = "CS_0003";
    private static String CS_0004 = "CS_0004";

    public void checkToken(TokenInfoResp result, List<AuthorityPair> authorityPairs) {
        chechError(result);
        List<Authority> authorities = result.getAuthorities();
        check(authorities, authorityPairs);
    }

    private void check(List<Authority> authorities, List<AuthorityPair> authorityPairs) {
        if (CollectionUtils.isEmpty(authorityPairs)) {
            return;
        }
        if (CollectionUtils.isEmpty(authorities)) {
            CasClientPreconditions.checkTokenPermission(false);
        }
        Map<String, String> hasAuthorities = convertAuthorityPairs(authorities);
        authorityPairs.forEach(authorityPair -> {
            String value = hasAuthorities.get(authorityPair.authorityKey());
            CasClientPreconditions.checkTokenPermission(compare(Integer.parseInt(value),
                    Integer.parseInt(authorityPair.authorityValue())));
        });
    }

    private boolean compare(int value, int authorityValue) {
        String hasAuthority = Integer.toBinaryString(value);
        String needAuthority = Integer.toBinaryString(authorityValue);
        int maxLen = needAuthority.length() - hasAuthority.length() >= 0 ? needAuthority.length() : hasAuthority.length();
        char[] hasAuthorityBits = Strings.padStart(hasAuthority, maxLen, '0').toCharArray();
        char[] needAuthorityBits = Strings.padStart(needAuthority, maxLen, '0').toCharArray();
        for (int i = 0; i < maxLen; i++) {
            if (needAuthorityBits[i] == '1' && hasAuthorityBits[i] != '1') {
                return false;
            }
        }
        return true;
    }

    private Map<String, String> convertAuthorityPairs(List<Authority> authorities) {
        return authorities.stream().collect(Collectors.toMap(Authority::getAuthorityKey, Authority::getAuthorityValue));
    }

    private void chechError(TokenInfoResp result) {
        if (result.getError() != null) {
            CasClientPreconditions.checkClientInvalid(!CS_0001.equals(result.getError().getErrorCode()));
            CasClientPreconditions.checkServerError(!CS_0003.equals(result.getError().getErrorCode()));
            CasClientPreconditions.checkTokenInvalid(!CS_0004.equals(result.getError().getErrorCode()));
        }
    }
}
