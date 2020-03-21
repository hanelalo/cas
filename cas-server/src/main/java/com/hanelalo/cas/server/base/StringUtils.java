package com.hanelalo.cas.server.base;

import com.google.common.base.Joiner;

import java.util.List;

public class StringUtils {

    public static boolean equals(String arg1,String arg2){
        return arg1 != null && arg1.equals(arg2);
    }

    public static boolean equalsIgnoreCase(String arg1,String arg2){
        return arg1 != null && arg1.equalsIgnoreCase(arg2);
    }

    public static String join(List<String> arg,String separator){
        return Joiner.on(separator).skipNulls().join(arg);
    }

}
