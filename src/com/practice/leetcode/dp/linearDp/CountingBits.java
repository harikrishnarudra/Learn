package com.practice.leetcode.dp.linearDp;

/**
 * 338. Counting Bits
 * Given an integer num, return an array of the number of 1's in the binary representation of every number in the range [0, num].
 *
 * Example 1:
 *
 * Input: num = 2
 * Output: [0,1,1]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * Example 2:
 *
 * Input: num = 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 *
 * Constraints:
 *
 * 0 <= num <= 105
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(32n). Can you do it in linear time O(n) and possibly in a single pass?
 * Could you solve it in O(n) space complexity?
 * Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
public class CountingBits {

    public static int[] countBitsWithInBuiltFunc(int num){
        int res[] = new int[num+1];
        for (int i = 0; i <= 4; i++) {
            String binaryString = Integer.toBinaryString(i);
            String s = binaryString.replaceAll("0", "");
            final int length = s.length();
            res[i] = length;
            System.out.println(length);
        }
        return res;
    }

    /**
     * The Logic here is Even numbers will have just 0 appended at the end when compared with its half.
     * Odd numbers have a plus 1 when compared to previous number (of bits with value 1)
     * 0 - 0
     * 1 - 1
     * 2 - 10
     * 3 - 11
     * 4 - 100
     * 5 - 101
     * 6 - 110
     * 7 - 111
     * 8 - 1000
     * similarly 16 - 10000
     *
     * @param num
     * @return
     */
    public static int[] countBitsWithoutInBuiltFunc(int num) {
        int res[] = new int[num + 1];
        res[0] = 0;
        if (num ==0){
            return res;
        }
        res[1] = 1;
        if (num == 1) {
            return res;
        }
        if(num > 1){
            for(int i=2;i<=num; i++){
                if (i % 2 == 0) {
                    res[i] = res[i/2];
                }
                else {
                    res[i] = res[i - 1]+1;
                }
            }
        }
        return res;
    }

    /**
     * Highest number of votes for this solution
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }


    public static void main(String[] args) {
        int num = 130;
//        countBitsWithInBuiltFunc(num);
        int[] ints = countBitsWithoutInBuiltFunc(num);
        for (int i:ints) {
            System.out.print(i+" ");
        }
        System.out.println("");
        ints = countBits(num);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
