package com.practice.model.bulkCars;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class CarIntentRequest {

    private String id;
    private String createdBy;
    private String sellerId;
    private OffsetDateTime effectiveDateTime;
    private String changeType;
    private String sellingUOM;
    private List<Car> carIntents;
}
