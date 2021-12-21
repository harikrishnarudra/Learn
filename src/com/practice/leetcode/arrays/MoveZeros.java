package com.practice.leetcode.arrays;

public class MoveZeros {

    public static int[] moveZeroes(int[] nums) {
        int zeroCount = 0;
        int[] result = new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeroCount++;
            }
            else{
                result[j++] = nums[i];
            }
        }
        for(int i=0;i<zeroCount;i++){
            result[j++] = 0;
        }
        return result;
    }

    public static int[] moveZeroesWithoutExtraSpace(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == 0) {
                if(nums[j] != 0){
                    swap(nums,i,j);
                    i++;
                }
            } else {
                i++;
            }
        }
        return nums;
    }
    private static void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static int[] moveZeroesWithoutExtraSpaceSwap(int[] nums) {
        int i = 0;
        int zeros = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {
                zeros++;
            } else {
                nums[i++] = nums[j];
            }
        }
        for(int k=nums.length-1;k>=nums.length-zeros;k--){
            nums[k] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] res = moveZeroesWithoutExtraSpaceSwap(new int[]{0,1,0,3,12});
        for(int i:res){
            System.out.println(i);
        }
    }
}
