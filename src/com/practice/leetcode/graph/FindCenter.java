package com.practice.leetcode.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FindCenter {

    public int findCenter(int[][] edges) {
        int length = edges.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<length;i++){
            int[] arr = edges[i];
            for(int j=0;j<2;j++){
                if (map.containsKey(arr[j])){
                    int count = map.get(arr[j]);
                    count ++;
                    map.put(arr[j], count);
                }
                else {
                    map.put(arr[j],1);
                }
            }
        }
        int keyLeng = map.keySet().size()-1;
        int result = -1;
        if(map.containsValue(keyLeng)){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> next = iterator.next();
                if(next.getValue().compareTo(keyLeng) == 0) {
                    result = next.getKey();
                }
            }
        }
        return result;
    }

    public int findCenter2(int[][] edges) {
        int[] firstPair = edges[0];
        int[] secondPair = edges[1];
        if (firstPair[0] == secondPair[0] || firstPair[0] == secondPair[1]) {
            return firstPair[0];
        } else {
            return firstPair[1];
        }
    }

    public static void main(String[] args) {
        FindCenter findCenter = new FindCenter();
        System.out.println(findCenter.findCenter(new int[][]{{1, 2},{2, 3},{4, 2}}));
        System.out.println(findCenter.findCenter(new int[][]{{1, 2}, {5, 1}, {3, 1}, {4, 1}}));
    }
}
