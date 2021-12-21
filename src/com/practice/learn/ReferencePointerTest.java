package com.practice.learn;

import com.practice.model.Fruit;

public class ReferencePointerTest {
    public static void main(String[] args) {
        Fruit f = new Fruit("Apple", "Red");
//        f = f+1;
        System.out.println(f);

        Integer y = 5;
        y +=1;
        System.out.println(y);
    }
}
