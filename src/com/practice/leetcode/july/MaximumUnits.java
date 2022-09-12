package com.practice.leetcode.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MaximumUnits {
    public int maximumUnits2(int[][] boxTypes, int truckSize) {
        /*Collections.sort(new ArrayList<ArrayList>(), new Comparator<List>(){
            @Override
            public int compare(List o1, List o2) {
                return ((Integer) o1.get(1)).compareTo((Integer) o2.get(1));
            }
        });*/


        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<boxTypes.length; i++){
            map.put(i,boxTypes[i][1]);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int cnt = truckSize;
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry: list){
            int numBox = boxTypes[entry.getKey()][0];
            if(numBox <= cnt){
                sum += numBox*entry.getValue();
                cnt -= numBox;
            }else{
                sum += cnt*entry.getValue();
                break;
            }
        }
        return sum;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int sum = 0;
        int[] boxesvsunits = new int[1001];
        for(int[] boxType:boxTypes){
            boxesvsunits[boxType[1]] += boxType[0];
        }
        for(int i=boxesvsunits.length-1; i>=0; i--){
            if(boxesvsunits[i] > 0){
                if(boxesvsunits[i] <= truckSize){
                    sum +=  boxesvsunits[i]*i;
                    truckSize -= boxesvsunits[i];
                }else{
                    sum += i * truckSize;
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumUnits m = new MaximumUnits();
        int[][] boxTypes = new int[][]{{1,3}, {2, 2}, {3, 1}};
        System.out.println(m.maximumUnits(boxTypes, 4));
        boxTypes = new int[][]{{1, 1}, {2, 2}, {3, 5}};
        System.out.println(m.maximumUnits(boxTypes, 4));
        boxTypes = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(m.maximumUnits(boxTypes, 10));
        boxTypes = new int[][]{{1, 1}, {2, 1}, {3, 1}};
        System.out.println(m.maximumUnits(boxTypes, 4));
    }
}
