package com.test.leetcode;

//1742. Maximum Number of Balls in a Box

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class CountBalls {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> cntMap =new HashMap<>();
        int cnt = 1;
        for (;lowLimit<=highLimit; lowLimit++){
            int sumVal = this.calculateSum(lowLimit);
            if (cntMap.containsKey(sumVal)){
                cnt = cntMap.get(sumVal);
                cnt += 1;
                cntMap.put(sumVal, cnt);
            }
            else{
                cntMap.put(sumVal, 1);
            }
        }
        Collection<Integer> values = cntMap.values();
        Optional<Integer> sorted = values.stream().max(Integer::compareTo);
        return sorted.get();
    }

    public int countBallsV2(int lowLimit, int highLimit) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        int max = 0;
        int cnt = 1;
        for (; lowLimit <= highLimit; lowLimit++) {
            int sumVal = this.calculateSum(lowLimit);
            if (cntMap.containsKey(sumVal)) {
                cnt = cntMap.get(sumVal);
                cnt += 1;
                cntMap.put(sumVal, cnt);
                max = Math.max(max, cnt);
            } else {
                cntMap.put(sumVal, 1);
            }
        }
       return max;
    }

    public int countBallsV3(int lowLimit, int highLimit) {
        int[] arr = new int[45];
        int max = 0;
        int cnt = 1;
        for (; lowLimit <= highLimit; lowLimit++) {
            int sumVal = this.calculateSum(lowLimit);
            cnt =  arr[sumVal];
            cnt += 1;
            arr[sumVal] = cnt;
            max = Math.max(max, cnt);
        }
        return max;
    }

    public int calculateSum(int num){
        int sum =0;
        while(num > 9){
            sum += num%10;
            num = num/10;
        }
        sum += num;
        return sum;
    }

    public static void main(String[] args) {
        CountBalls countBalls = new CountBalls();
        System.out.println(countBalls.countBallsV3(1,10));
        System.out.println(countBalls.countBallsV3(5, 15));
        //System.out.println(countBalls.calculateSum(1465));
    }
}
