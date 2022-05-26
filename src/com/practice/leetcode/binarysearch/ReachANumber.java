package com.practice.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 754. Reach a Number
 * You are standing at position 0 on an infinite number line. There is a destination at position target.
 *
 * You can make some number of moves numMoves so that:
 *
 * On each move, you can either go left or right.
 * During the ith move (starting from i == 1 to i == numMoves), you take i steps in the chosen direction.
 * Given the integer target, return the minimum number of moves required (i.e., the minimum numMoves) to reach the destination.
 *
 * Example 1:
 *
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to -1 (2 steps).
 * On the 3rd move, we step from -1 to 2 (3 steps).
 * Example 2:
 *
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the 1st move, we step from 0 to 1 (1 step).
 * On the 2nd move, we step from 1 to 3 (2 steps).
 *
 *
 * Constraints:
 *
 * -10^9 <= target <= 10^9
 * target != 0
 */
public class ReachANumber {
    public int reachNumber(int target) {
        List<Integer> items = new ArrayList<>();
        items.add(0);
        int i=1;
        while(!items.contains(target)){
            List<Integer> newItems = new ArrayList<>();
            for(int j=0;j<items.size();j++){
                int plusItem = items.get(j) + i;
                if(!newItems.contains(plusItem)){
                    newItems.add(plusItem);
                }
                int minusItem = items.get(j) - i;
                if (!newItems.contains(minusItem)) {
                    newItems.add(minusItem);
                }
            }
            items = newItems;
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        ReachANumber reachANumber = new ReachANumber();
        System.out.println(reachANumber.reachNumber(6));
        System.out.println(reachANumber.reachNumber(1236876879));
    }

}
