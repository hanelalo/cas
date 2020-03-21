package com.hanelalo.cas.client.api;

import java.io.Serializable;

public class Authority implements Serializable {
    private static final long serialVersionUID = 1788146940674725791L;
    private String authorityKey;
    private String authorityValue;

    public Authority(){}

    public Authority(String authorityKey, String authorityValue) {
        this.authorityKey = authorityKey;
        this.authorityValue = authorityValue;
    }

    public String getAuthorityKey() {
        return authorityKey;
    }

    public Authority setAuthorityKey(String authorityKey) {
        this.authorityKey = authorityKey;
        return this;
    }

    public String getAuthorityValue() {
        return authorityValue;
    }

    public Authority setAuthorityValue(String authorityValue) {
        this.authorityValue = authorityValue;
        return this;
    }
}
