package com.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1. TWO SUM
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    static boolean findSumOfTwo(int[] A, int val) {
        //TODO: Write - Your - Code
        // Instead of Map, can we use HashSet ?
        /*Map<Integer,Integer> hashM = new HashMap<>();
        for (int i:A) {
            hashM.put(i,i);
        }*/
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(set.contains(val-A[i])) return true;
            set.add(A[i]);
            /*if(val>A[i]){
                int nextEle = val-A[i];
                if(hashM.containsKey(nextEle)){
                    return true;
                }
            }*/
        }
        return false;
    }

    static int[] findSumOfTwoWithVals(int[] A, int val) {
        int[] result = new int[2];
        Map<Integer,Integer> hashM = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int nextEle = val-A[i];
            if(hashM.containsKey(nextEle) && i!=hashM.get(nextEle)){
                result[0]= hashM.get(nextEle);
                result[1]=i;
                break;
            }
            hashM.put(A[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
//        int[] ints = findSumOfTwoWithVals(new int[]{2, 7, 11, 15}, 9);
//        int[] ints = findSumOfTwoWithVals(new int[]{3,3}, 6);
//        int[] ints = findSumOfTwoWithVals(new int[]{3,2,4}, 6);
        int[] ints = findSumOfTwoWithVals(new int[]{2, 7, 11, 15, 54, 5436, 6564, 432, 454, 23, 21, 323, 541, 213}, 5491);
        System.out.println(ints[0]+","+ints[1]);
//        System.out.println(findSumOfTwoWithVals(new int[]{2,7,11,15},9));
    }
}
