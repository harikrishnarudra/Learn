package com.practice.learn;

import com.practice.model.bulkCars.Car;
import com.practice.model.bulkCars.CarIntentRequest;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class FilterFromJsonStream {

    private static CarIntentRequest createCarIntentRequest(){
        return null;
    }/*{

        String id = UUID.randomUUID().toString();
        List<Car> cars = List.of(Car.builder().make("Maruti").model("Swift").chassis("CHASSIS_01").identityNum("IN001").build(),
                Car.builder().make("Honda").model("City").chassis("CHASSIS_02").identityNum("IN002").build(),
                Car.builder().make("Toyota").model("Corolla").chassis("CHASSIS_03").identityNum("IN003").build(),
                Car.builder().make("Hyundai").model("i20").chassis("CHASSIS_04").identityNum("IN004").build());

        return CarIntentRequest.builder().carIntents(cars)
                .createdBy("Seller01")
                .changeType("Looking For Quotes")
                .effectiveDateTime(Instant.now().atOffset(ZoneOffset.UTC))
                .sellerId("Seller01")
                .id(id)
                .sellingUOM("Online")
                .build();
    }*/

    public static void main(String[] args) {
        /*CarIntentRequest request = createCarIntentRequest();
        List<String> collect = request.getCarIntents().stream()
                .map(car -> car.getMake())
                .collect(Collectors.toList());
        collect.stream().forEach(System.out::println);*/

    }
}
