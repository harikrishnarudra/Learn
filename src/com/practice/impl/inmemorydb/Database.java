package com.practice.impl.inmemorydb;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class Database {
    private String databaseName;
    private Map<String,Table> tables;
    private Date createdDate;

    public Database(String databaseName) {
        this.databaseName = databaseName;
    }

    public Table createTable(String tableName){
        return new Table(tableName);
    }

    public Table getTable(String tableName) throws Exception {
        if(tables.containsKey(tableName)){
            return tables.get(tableName);
        }
        else{
            throw new Exception("No table found");
        }
    }

    public void addTable(String tableName, Table table){
        tables.put(tableName, table);
    }
}
