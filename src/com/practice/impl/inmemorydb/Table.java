package com.practice.impl.inmemorydb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Table {

    private String tableName;
    private Map<Integer, Row> rows;
    private Date createdDate;

    public Table(String tableName) {
        this.tableName = tableName;
        this.createdDate = new Date();
    }

    public void addRow(int rowId, Map<String, String> rowValueMap){
        if(rows.containsKey(rowId)){
            throw new IllegalStateException("Row already exists");
        }
        else {
            Row row = new Row(rowId, rowValueMap);
            rows.put(rowId, row);
        }
    }

    public Row getRow(int rowId){
        return rows.getOrDefault(rowId, null);
    }

    public void deleteRow(int rowId){
        if(rows.containsKey(rowId)) {
            rows.remove(rowId);
        }
    }
}
