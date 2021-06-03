package com.test.leetcode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class GoodPairs {
    public int numIdenticalPairsDebug(int[] nums) {
        AtomicInteger totalCount = new AtomicInteger();
        int incIndex = 0;
        if(nums != null && nums.length>0){
            IntStream.range(incIndex, nums.length).forEach(value -> {
                System.out.println("value -> " +value);
                long count = IntStream.range(value + 1, nums.length)
                        .filter(nextValue -> {
                            System.out.println("next value -> " + nextValue);
                            if (nums[value] == nums[nextValue]) {
                                System.out.println("Elements are (" + nums[value] + "," + nums[nextValue] + ")");
                                return true;
                            }
                            return false;
                        })
                        .count();
                totalCount.addAndGet((int) count);
                System.out.println("Inner count value " +count);
            });
        }
        return totalCount.intValue();
    }

    public int numIdenticalPairs(int[] nums) {
        AtomicInteger totalCount = new AtomicInteger();
        int incIndex = 0;
        if (nums != null && nums.length > 0) {
            IntStream.range(incIndex, nums.length).forEach(value -> {
                long count = IntStream.range(value + 1, nums.length)
                        .filter(nextValue -> nums[value] == nums[nextValue]).count();
                totalCount.addAndGet((int) count);
            });
        }
        return totalCount.intValue();
    }

    public static void main(String[] args){
        GoodPairs goodPairs = new GoodPairs();
        int[] inp = new int[]{1,2,3,1,1,3};
        //int[] inp = new int[]{1, 1, 1, 1};
        //int[] inp = new int[]{1, 2, 3};
        //int[] inp = new int[]{};
        System.out.println("\n Result is "+ goodPairs.numIdenticalPairs(inp));
    }
}
