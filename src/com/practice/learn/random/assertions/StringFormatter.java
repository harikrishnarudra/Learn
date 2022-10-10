package com.practice.learn.random.assertions;

import org.apache.commons.lang3.StringUtils;

public class StringFormatter {
    public static void main(String[] args) {
        String constant = "/test/{someId}";
        String constant2 = constant.replace(constant.split("/")[2],"value");
        System.out.println(constant2);
        String res = constant.split("/")[1];
        System.out.println(res);

        String[] arr = constant.split("\\{");
        System.out.println(arr[0]+"---"+arr[1]);

        String strUtil = StringUtils.joinWith("/", "someTest", constant.split("/")[1]);
        System.out.println(strUtil);

    }
}
