package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1313. Decompress Run-Length Encoded List
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 * Return the decompressed list.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * Example 2:
 *
 * Input: nums = [1,1,2,3]
 * Output: [1,3,3]
 */
public class DecompressRLElist {
    //Worst performance - 16ms only because of using streams to convert arraylist to array
    public int[] decompressRLElist2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int k = 0;
        int len = nums.length/2;
        for(int i=0;i < len; i++){
            int x = nums[2*i+1];
            System.out.println("x= "+x);
            int times = nums[2*i];
            System.out.println("times= " + times);
            while(k++<times){
                res.add(x);
            }
            k=0;
        }
        int[] arr = res.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    /**
     * 1 ms performance
     * @param nums
     * @return
     */
    public int[] decompressRLElist(int[] nums) {
        int totalCapacity = 0;
        for(int i=0;i<nums.length;i+=2){
            totalCapacity += nums[i];
        }
        int k = 0, l =0;
        int[] res = new int[totalCapacity];
        for(int i=0;i<nums.length-1; i+=2){
            int y = nums[i];
            int x = nums[i+1];
            while (k++ < y) {
                res[l++] = x;
            }
            k = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        DecompressRLElist d = new DecompressRLElist();
        int[] ints = d.decompressRLElist(new int[]{1, 1, 2, 3});
        int[] int2 = d.decompressRLElist(new int[]{0, 1, 2, 3});
        int[] int3 = d.decompressRLElist(new int[]{1, 2, 3, 4});
        Arrays.stream(ints).forEach(System.out::println);
        Arrays.stream(int2).forEach(System.out::println);
        Arrays.stream(int3).forEach(System.out::println);
    }
}
