package com.practice.learn;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MapValues {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("test", "test1");
        map.put("test", "test2");
        map.put("test", "test3");
        map.put("test", "test3");
        final Collection<String> values = map.values();

        Map<String, List> map2 = new HashMap<>();
        map2.put("test1", List.of("test1"));
        Optional<List> clusterIdList = Optional.ofNullable(map2.get("test"));
        List list = clusterIdList.orElse(Collections.EMPTY_LIST);
        System.out.println(list);
    }
}
