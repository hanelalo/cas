package com.hanelalo.cas.client.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface AuthorityPair {
    String authorityKey();
    String authorityValue();
}
