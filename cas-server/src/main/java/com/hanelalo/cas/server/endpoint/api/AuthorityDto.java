package com.hanelalo.cas.server.endpoint.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel("权限信息")
public class AuthorityDto implements Serializable {
    private static final long serialVersionUID = -6557771253937645703L;
    @ApiModelProperty("权限名")
    private String authorityKey;
    @ApiModelProperty("权限值")
    private String authorityValue;

    /**
     * Get authorityKey
     **/
    public String getAuthorityKey() {
        return authorityKey;
    }

    /**
     * @param authorityKey authorityKey
     * @return this
     **/
    public AuthorityDto setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
        return this;
    }

    /**
     * Get authorityValue
     **/
    public String getAuthorityValue() {
        return authorityValue;
    }

    /**
     * @param authorityValue authorityValue
     * @return this
     **/
    public AuthorityDto setAuthorityValue(String authorityValue) {
        this.authorityValue = authorityValue;
        return this;
    }
}
