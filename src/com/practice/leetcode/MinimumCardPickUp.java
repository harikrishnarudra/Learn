package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MinimumCardPickUp {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        Map<Integer, Integer> minMap = new HashMap<>();
        for(int i=0;i<cards.length;i++){
            int key = cards[i];
            if(indexMap.containsKey(key)){
                List<Integer> indexList = indexMap.get(key);
                if(indexList.size()<2){
                    indexList.add(i);
                    indexMap.put(key, indexList);
                    int minVal = i-indexList.get(0)+1;
                    minMap.put(key, minVal);
                }else{
                    int currVal = i-indexList.get(1)+1;
                    if(currVal<minMap.get(key)){
                        minMap.put(key, currVal);
                        indexList.remove(0);
                        indexList.add(i);
                    }
                }
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(i);
                indexMap.put(key, l);
            }
        }
        int resMin = -1;
        Iterator<Integer> iterator = minMap.keySet().iterator();

        while (iterator.hasNext()){
            int key = iterator.next();
            int val = minMap.get(key);
            if(resMin == -1){
                resMin = val;
            }
            if(val < resMin){
                resMin = val;
            }
        }
        return resMin;
    }

    public static void main(String[] args) {
        MinimumCardPickUp m = new MinimumCardPickUp();
        System.out.println(m.minimumCardPickup(new int[]{3,4,2,3,4,7}));
        System.out.println(m.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7, 4}));
        System.out.println(m.minimumCardPickup(new int[]{1, 0, 5, 3}));
        System.out.println(m.minimumCardPickup(new int[]{1}));
        System.out.println(m.minimumCardPickup(new int[]{1, 1}));
    }
}
