package com.practice.leetcode.contest;

import java.util.HashSet;
import java.util.Set;

public class MaximumSubarraySum {
    public long maximumSubarraySum(int[] nums, int k) {
        int i=0, j=i+k;
        int xorOp = nums[0];
        Set<Integer> set = new HashSet<>();
        int sum=0, max=0, m=i;
        while(j < nums.length){
            for (; i < j ; i++) {
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                    sum += nums[i];
                }else{
                    set.remove(nums[m]);
                    sum -= nums[m];
                    m = m + 1;
                    j = m + k;
                    set.add(nums[i]);
                    sum += nums[i];
                    if(j > nums.length){
                        break;
                    }
                }
            }
            max = Math.max(max, sum);
            set.remove(nums[m]);
            sum -= nums[m];
            m = m + 1;
            j = m + k;
            i = j-1;
        }
        return max;

    }

    public static void main(String[] args) {
        MaximumSubarraySum m = new MaximumSubarraySum();
        System.out.println(m.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
