package com.test.learn;

import java.util.List;
import java.util.Optional;

public class OptionalCase {

    public static void main(String[] args) {
        List<String> list = List.of("test","true");
        System.out.println(Optional.ofNullable(list));
        Boolean value = Optional.ofNullable(list)
                .map(ele -> !list.isEmpty())
                .orElse(false);
        System.out.println(value);
    }
}
