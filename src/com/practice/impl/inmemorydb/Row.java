package com.practice.impl.inmemorydb;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Builder
@Getter
@Setter
public class Row {
    private int rowId;
    private Map<String, String> rowValueMap;
    private Date createdDate;
    private Date updatedDate;

    public Row(int rowId, Map<String, String> rowValueMap) {
        this.rowId = rowId;
        this.rowValueMap = rowValueMap;
        this.createdDate = new Date();
        this.updatedDate = new Date();
    }
}
