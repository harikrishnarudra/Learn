package com.practice.learn.random.assertions;

public class StaticTest {
    static {
        System.out.println("test");

    }

    public void print() {
        System.out.println("Test2");
    }

    public static void main(String[] args) {
        StaticTest b = new StaticTest();
        b.print();
        StaticTest b2 = new StaticTest();
        b2.print();
    }
}
