package com.practice.learn.random.assertions;

public class StringOperations {
    public static void main(String[] args) {
        String res = "1232323".replace("2", "");
        res = "1232323".repeat(3);
        int x = "ABCDED".codePointBefore(3);
        System.out.println(res);
        System.out.println(x);
    }
}
