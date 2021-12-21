package com.practice.leetcode.arrays;

/**
 *
 * 2011. Final Value of Variable After Performing Operations
 *
 * There is a programming language with only four operations and one variable X:
 *
 * ++X and X++ increments the value of the variable X by 1.
 * --X and X-- decrements the value of the variable X by 1.
 * Initially, the value of X is 0.
 *
 * Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
 *
 * Example 1:
 *
 * Input: operations = ["--X","X++","X++"]
 * Output: 1
 * Explanation: The operations are performed as follows:
 * Initially, X = 0.
 * --X: X is decremented by 1, X =  0 - 1 = -1.
 * X++: X is incremented by 1, X = -1 + 1 =  0.
 * X++: X is incremented by 1, X =  0 + 1 =  1.
 */
public class FinalValueAfterOperations {
    public int finalValueAfterOperations(final String[] operations) {
        int x =0;
        for(String s:operations){
            switch (s){
                case "++X": x+=1;
                    break;
                case "X++": x += 1;
                    break;
                case "--X": x -= 1;
                    break;
                case "X--": x -= 1;
                    break;
            }
        }
        return x;
    }

    /**
     *
     * Someone's thinking approach for this problem with 0ms
     */

    public int finalValueAfterOperations2(String[] operations) {
        int ans = 0;
        for (String str : operations) {
            if (str.charAt(1) == '+')
                ans++;
            else
                ans--;
        }
        return ans;
    }


    public static void main(String[] args) {
        FinalValueAfterOperations f = new FinalValueAfterOperations();
        System.out.println(f.finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));
        System.out.println(f.finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));
        System.out.println(f.finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"}));
    }
}
