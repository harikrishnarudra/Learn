package com.practice.model.vehicles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class FourWheeler extends Vehicle{
    private String steeringType;
    private boolean childLockSupport;

    public FourWheeler() {
        super();
    }
}
