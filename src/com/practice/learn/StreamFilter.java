package com.test.learn;

import com.test.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class StreamFilter {

    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));
        list=new ArrayList<>();
        boolean exists = list.stream()
                .anyMatch(fruit -> fruit.getColor().equalsIgnoreCase("REDu"));
        System.out.println(exists);
//        List<Fruit> empList = new ArrayList<>();
        List<Fruit> empList = null;
        System.out.println(empList.size());
        System.out.println(empList.isEmpty());
        System.out.println(empList.stream().findFirst().orElse(null));
        if (null instanceof String){
            System.out.println("test");
        }else {
            System.out.println("test2");
        }
    }
}
