package com.test.learn;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class IsEmptyCheck {

    public static void main(String[] args) {
        String var = null;
//        System.out.println(isNull(var.trim()));
        if (!isEmpty(var.trim())){
            System.out.println(var.trim());
        }
    }
}
