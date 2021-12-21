package com.practice.learn;

public class AutoUnboxTest {

    public static Integer doSomething(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 4;
        System.out.println(doSomething(a,b));
    }
}
