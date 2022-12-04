package com.practice.leetcode.contest;

import java.util.Arrays;

public class UnEqualTriplets {
    public int unequalTriplets(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] != nums[j]){
                    for(int k=j+1;k<n;k++){
                        if(nums[i] != nums[k]
                                && nums[j] != nums[k]){
                            res ++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        UnEqualTriplets u = new UnEqualTriplets();
        System.out.println(u.unequalTriplets(new int[]{4, 4, 2, 4, 3}));
        System.out.println(u.unequalTriplets(new int[]{1, 1, 1, 1, 1}));
        int[] n = new int[100];
        Arrays.fill(n, 1);
        System.out.println(u.unequalTriplets(n));
    }
}
