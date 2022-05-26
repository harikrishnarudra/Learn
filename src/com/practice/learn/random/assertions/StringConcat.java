package com.practice.learn.random.assertions;

public class StringConcat {
    public static void main(String[] args) {
        String s = "test";
        s.concat("_").concat("abc");
        System.out.println(s);
    }
}
