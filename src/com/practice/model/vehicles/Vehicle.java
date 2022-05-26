package com.practice.model.vehicles;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class Vehicle {
    private int numOfWheels;
    private boolean spareWheelExists;
    private String vehicleNumber;
}
