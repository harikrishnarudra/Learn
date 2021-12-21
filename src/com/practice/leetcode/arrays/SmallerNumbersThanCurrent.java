package com.practice.leetcode.arrays;

import java.util.Arrays;
/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 *
 * Return the answer in an array.
 *
 * Example 1:
 *
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 * Explanation:
 * For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
 * For nums[1]=1 does not exist any smaller number than it.
 * For nums[2]=2 there exist one smaller number than it (1).
 * For nums[3]=2 there exist one smaller number than it (1).
 * For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
 */
public class SmallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] process = new int[500];
        for(int i:nums){
            int k = process[i];
            k++;
            process[i] = k;
        }
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int sumV = 0;
            for(int j=0;j<nums[i];j++){
                sumV += process[j];
            }
            result[i] = sumV;
//            result[i] = Arrays.stream(process,0,nums[i]).sum();
        }
        return result;
    }

    /**
     * I like this approach
     */
    private static final int MAX = 100;

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] count = new int[MAX + 2];
        for(int i:nums){
            count[i+1]++;
        }
        for(int i=1;i<=MAX;i++){
            count[i] += count[i-1];
        }
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            result[i] = count[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        SmallerNumbersThanCurrent s = new SmallerNumbersThanCurrent();
        int[] res = s.smallerNumbersThanCurrent2(new int[]{8, 1, 2, 2, 3});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("======");
        res = s.smallerNumbersThanCurrent(new int[]{6, 5, 4, 8});
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("======");
        res = s.smallerNumbersThanCurrent(new int[]{6, 6, 6, 6});
        Arrays.stream(res).forEach(System.out::println);

    }
}
