package com.practice.learn.random.assertions;

import java.util.Arrays;
import java.util.stream.Stream;

class Car<T>{
    void set(T t){

    }
}
public class MyClass {
    public MyClass(){
        super();
    }

    public static void main(String[] args) {
        /*MyClass c = new MyClass();
        System.out.println(c);*/

       /* Car<String> cs = new Car<>();
        Car c1 = cs;
        c1.set(cs);*/
        /*Object[] a = {new Integer(5), new String("f"), new Integer(6), new Boolean(true)};
        Arrays.sort(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i].toString());
            System.out.println(" ");
        }*/
        Stream.of(1,2,3,4,5,6,7).skip(5).forEach(System.out::println);
    }
}
