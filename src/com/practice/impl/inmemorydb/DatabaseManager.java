package com.practice.impl.inmemorydb;

import java.util.Map;

public class DatabaseManager {
    private Map<String, Database> databaseMap;

    public Database createDatabase(String databaseName){
        if(databaseMap.containsKey(databaseName)){
            return databaseMap.get(databaseName);
        }
        else {
            databaseMap.put(databaseName,new Database(databaseName));
        }
        return databaseMap.get(databaseName);
    }

    public Database getDatabase(String databaseName) {
        return databaseMap.getOrDefault(databaseName, null);
    }
}
