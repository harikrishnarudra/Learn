package com.practice.leetcode.dp.linearDp;

public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result=0, left=0, right=0, numZeros=0;
        while(right < nums.length){
            if(nums[right]==0){
                numZeros++;
            }
            while(numZeros == 2){
                if(nums[left] == 0){
                    numZeros --;
                }
                left ++;
            }
            result = Math.max(result, right-left+1);
            right++;
        }
        return result;

    }

    public static void main(String[] args) {
        FindMaxConsecutiveOnes f = new FindMaxConsecutiveOnes();
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1, 0, 0, 0, 1}));
        System.out.println(f.findMaxConsecutiveOnes(new int[]{0, 0, 0, 0, 0}));
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0}));
        System.out.println(f.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1}));
    }
}
