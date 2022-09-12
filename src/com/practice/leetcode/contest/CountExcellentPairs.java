package com.practice.leetcode.contest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CountExcellentPairs {
    public long countExcellentPairs2(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<nums.length; i++){
            for(int j=i;j<nums.length;j++){
                String s = nums[i] + "+" + nums[j];
                String reverse = nums[j] + "+" + nums[i];
                if(!set.contains(s) && !set.contains(reverse) &&
                        (hammingWeight(nums[i] & nums[j]) + hammingWeight(nums[i] | nums[j]) >= k) ){
                    set.add(s);
                    set.add(reverse);
                }
            }
        }
        return set.size();
    }

    public long countExcellentPairs3(int[] nums, int k) {
        Set<String> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                String s = nums[i] + "+" + nums[j];
                String reverse = nums[j] + "+" + nums[i];
                if (!set.contains(s) && !set.contains(reverse)){
                    int andOp = nums[i] & nums[j];
                    int orOp = nums[i] | nums[j];
                    if(!map.containsKey(andOp)){
                        map.put(andOp, hammingWeight(andOp));
                    }
                    if (!map.containsKey(orOp)) {
                        map.put(orOp, hammingWeight(orOp));
                    }
                    if(map.get(andOp) + map.get(orOp) >= k){
                        set.add(s);
                        set.add(reverse);
                    }
                }
            }
        }
        return set.size();
    }

    public long countExcellentPairs(int[] nums, int k) {
        long res = 0;
        int[] bitCnt = new int[32];
        Set<Integer> set = new HashSet<>();
        for(int a:nums){
            if(!set.contains(a)){
                set.add(a);
                bitCnt[Integer.bitCount(a)]++;
            }
        }
        for(int i=0;i<32;i++){
            for(int j=0;j<32;j++){
                if(i+j >=k){
                    res += bitCnt[i] * bitCnt[j];
                }
            }
        }

        return res;
    }

    private int hammingWeight(int n){
        int res = 0;
        while(n != 0){
            res += n&1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        CountExcellentPairs c = new CountExcellentPairs();
        System.out.println(c.countExcellentPairs(new int[]{1,2,3,1}, 3));
        System.out.println(c.countExcellentPairs(new int[]{5, 1, 1}, 3));
        System.out.println(c.countExcellentPairs(new int[]{5, 1, 1}, 10));
    }
}
