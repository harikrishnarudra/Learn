package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.IntUnaryOperator;

/**
 * 1389. Create Target Array in the Given Order
 * Given two arrays of integers nums and index. Your task is to create target array under the following rules:
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 * It is guaranteed that the insertion operations will be valid.
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 *
 * Input: nums = [1], index = [0]
 * Output: [1]
 */
public class CreateTargetArray {
    //Too much thinking here. Don't make it complex, think simple
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[nums.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<index.length;i++){
            int key = index[i];
            if(map.containsKey(key)){
                List<Integer> integers = map.get(key);
                integers.add(0, nums[key]);
            }else{
                List<Integer> integers = new ArrayList<>();
                integers.add(nums[key]);
            }
        }
        int k=0;
        Set<Integer> integers = map.keySet();
        for(int i:integers){
            List<Integer> integers1 = map.get(i);
            /*while(integers1.size()){
                res[k++] = integers1.get();
            }*/
        }

        return res;
    }

    public int[] createTargetArray2(int[] nums, int[] index) {
        LinkedList list = new LinkedList<Integer>();
        for(int i=0; i< nums.length; i++){
            int ind = index[i];
            list.add(ind, nums[i]);
        }
        int[] arr = list.stream().mapToInt(i -> (int) i).toArray();
        return arr;
    }

    public int[] createTargetArray3(int[] nums, int[] index) {
        LinkedList list = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int ind = index[i];
            list.add(ind, nums[i]);
        }
        int[] target = new int[nums.length];
        Object[] objects = list.toArray();
        for(int i=0;i<objects.length;i++){
            target[i] = (int) objects[i];
        }
        return target;
    }

    public int[] createTargetArray4(int[] nums, int[] index) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            arrayList.add(index[i], nums[i]);
        }
        int[] target = new int[len];
        for (int i = 0; i < len; i++) {
            target[i] = arrayList.get(i);
        }
        return target;
    }

    public static void main(String[] args) {
        CreateTargetArray c = new CreateTargetArray();
        int[] ints = c.createTargetArray2(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        Arrays.stream(ints).forEach(System.out::println);
    }
}
