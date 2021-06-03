package com.test.learn;

import com.test.model.Fruit;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class FindFirstFromMap {

    public static void main(String[] args) {
        List<Fruit> list = List.of(new Fruit("Apple", "Red"),
                new Fruit("Guava", "Green"), new Fruit("Carrot", "Orange"));
        Map<String, Fruit> fruitMap = new HashMap<>();
        fruitMap.put("Apple", new Fruit("Apple", "Red"));
        fruitMap.put("Guava", new Fruit("Guava", "Green"));
        fruitMap.put("Carrot", new Fruit("Carrot", "Orange"));

        Optional<String> color = Optional.ofNullable(fruitMap)
                .map(Map::entrySet)
                .map(Set::stream)
                .flatMap(Stream::findFirst)
                .map(Map.Entry::getValue)
                .map(Fruit::getColor);
//                .orElseGet(()-> {return Optional.of("test");});

    }

}
