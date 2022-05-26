package com.practice.learn.random.assertions;

import java.util.HashSet;
import java.util.Set;

public class SetRetainAll {
    public static void main(String[] args) {
        Set<String> s1 = new HashSet<>();
        s1.add("A");
        s1.add("B");
        s1.add("C");
        Set<String> s2 = new HashSet<>();
        s2.add("A");
        s2.add("B");
        boolean b = s1.retainAll(s2);
        System.out.println(b);
        s1.stream().forEach(System.out::println);
        s2.stream().forEach(System.out::println);
    }
}
