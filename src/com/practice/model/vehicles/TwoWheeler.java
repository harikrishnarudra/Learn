package com.practice.model.vehicles;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class TwoWheeler extends Vehicle{
    private String type;
    private boolean isPillionExists;
}
