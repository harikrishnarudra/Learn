package com.practice.learn;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class StringUtilsTest {
    public String doConcat(Object...args){
        return StringUtils.joinWith("-", args);
    }

    public static void main(String[] args) {
        StringUtilsTest s = new StringUtilsTest();
        System.out.println(s.doConcat("tes1","test2","test3"));
        System.out.println(s.doConcat("tes1"));
        System.out.println(s.doConcat(""));
        System.out.println(s.doConcat("tes1",""));
//        System.out.println(s.doConcat(null));
        System.out.println(s.doConcat("tes1", null));
        System.out.println(s.doConcat(null, "tes1"));
    }
}
