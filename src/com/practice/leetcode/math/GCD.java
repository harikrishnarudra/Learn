package com.practice.leetcode.math;

/**
 * Euclidean algorithm - https://crypto.stanford.edu/pbc/notes/numbertheory/euclid.html
 */

public class GCD {
    public int findGCD(int[] nums) {
        int a = nums[0], b= nums[0];
        for(int i=1; i<nums.length;i++){
            if(nums[i] < a){
                a = nums[i];
            }
            if (nums[i] > b) {
                b = nums[i];
            }
        }
        while(a > 0){
            int temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.findGCD(new int[]{33, 27}));
    }
}
