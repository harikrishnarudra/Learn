package com.practice.learn;

import org.apache.commons.lang3.ObjectUtils;

public class ObjectUtilsTest {
    public static void main(String[] args) {
        System.out.println(ObjectUtils.isEmpty(""));
        System.out.println(ObjectUtils.isEmpty(null));
        System.out.println(ObjectUtils.isEmpty(ObjectUtils.NULL));
    }

}
