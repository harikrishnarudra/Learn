package com.practice.learn;

import com.practice.model.Fruit;

import java.util.List;
import java.util.stream.Collectors;

public class CloneTest extends Object{

    public static void main(String[] args) throws CloneNotSupportedException{
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));
        Fruit f = new Fruit("Apple", "Red");
        Fruit clone = f.clone();
        System.out.println(f==clone);
        System.out.println(f.getColor() +"----"+ clone.getColor());
        System.out.println(f.getFruitName() + "----" + clone.getFruitName());
        f.setColor("test");
        System.out.println(f.getColor() + "--After setting --" + clone.getColor());



        List<Fruit> testColor = list.stream().map(Fruit::clone)
                .map(clonedFruit -> {
                    clonedFruit.setColor("testColor");
                    return clonedFruit;
                })
                .collect(Collectors.toList());

        System.out.println("before cloning");
        list.stream().forEach(System.out::println);
        System.out.println("after cloning");
        testColor.stream().forEach(System.out::println);

    }
}
