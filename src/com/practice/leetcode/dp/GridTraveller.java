package com.test.leetcode.dp;

import java.util.HashMap;
import java.util.Map;


public class GridTraveller {

    private Map<String, Long> map = new HashMap<String, Long>();
    public long gridTraveller(int m, int n) {
        String key = m + "," + n;
        if (map.containsKey(key)) return map.get(key);
        if (m == 0 || n == 0) return 0;
        if (m == 1 && n == 1) return 1;
        map.put(key, gridTraveller(m - 1, n) + gridTraveller(m, n - 1));
        return map.get(key);
    }

    public static void main(String[] args) {

        GridTraveller gridTraveller = new GridTraveller();
        System.out.println(gridTraveller.gridTraveller(1, 1));
        System.out.println(gridTraveller.gridTraveller(3, 2));
        System.out.println(gridTraveller.gridTraveller(2, 3));
        System.out.println(gridTraveller.gridTraveller(3, 3));
        System.out.println(gridTraveller.gridTraveller(18, 18));
    }
}

/*public class GridTraveller {

    public long gridTraveller(int m, int n, Map<String, Long> map){
        String key = m+","+n;
        if (map.containsKey(key)) return map.get(key);
        if (m==0 || n==0) return 0;
        if (m==1 && n==1) return 1;
        map.put(key,gridTraveller(m-1, n, map) + gridTraveller(m, n-1, map));
        return map.get(key);
    }

    public static void main(String[] args) {
        Map<String, Long> map = new HashMap<String, Long>();
        GridTraveller gridTraveller = new GridTraveller();
        System.out.println(gridTraveller.gridTraveller(1,1, map));
        System.out.println(gridTraveller.gridTraveller(3, 2,map));
        System.out.println(gridTraveller.gridTraveller(2, 3,map));
        System.out.println(gridTraveller.gridTraveller(3, 3,map));
        System.out.println(gridTraveller.gridTraveller(18, 18,map));
    }
}*/
