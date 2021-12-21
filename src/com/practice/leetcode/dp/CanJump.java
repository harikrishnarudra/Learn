package com.practice.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class CanJump {
    public boolean canJump(int[] nums) {
        int reachable =0;
        for(int i=0;i<nums.length;++i){
            if(reachable >= nums.length){
                break;
            }
            if(i>reachable) return false;
            reachable = Math.max(reachable, i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        /*System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump.canJump(new int[]{1, 2, 3,4}));
        System.out.println(canJump.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{2, 0, 1, 1, 4}));
        System.out.println(canJump.canJump(new int[]{2}));*/
        System.out.println(canJump.canJump(new int[]{2,3,0,0}));
    }
}
