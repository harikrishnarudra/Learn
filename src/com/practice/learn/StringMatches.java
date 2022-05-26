package com.practice.learn;

public class StringMatches {
    public static void main(String[] args) {
        System.out.println("matches".matches("matches"));
        System.out.println("matches".matches("maches"));
        System.out.println("matches".matches(""));
        System.out.println("".matches(""));
        System.out.println("".matches("maches"));
        System.out.println("matches".equalsIgnoreCase(null));
        System.out.println("matches".matches(null));
    }
}
