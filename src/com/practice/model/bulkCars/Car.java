package com.practice.model.bulkCars;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Car {

    private String make;
    private String model;
    private String chassis;
    private String identityNum;
}
