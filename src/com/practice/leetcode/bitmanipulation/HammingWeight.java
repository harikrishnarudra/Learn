package com.practice.leetcode.bitmanipulation;

/**
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 *
 * Example 1:
 *
 * Input: n = 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: n = 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: n = 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 * Constraints:
 *
 * The input must be a binary string of length 32.
 */
public class HammingWeight {
    // you need to treat n as an unsigned value


    public long hammingWeight2(int n) {
        int res = 0;
        while(n !=0){
            res += n&1;
            n >>>= 1;
        }
        return res;
    }

    public int hammingWeight(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        return hammingWeight(n>>1) + (n&1);
    }

    public static void main(String[] args) {
        HammingWeight h = new HammingWeight();
        System.out.println(h.hammingWeight(13));
        System.out.println(h.hammingWeight(3));
        System.out.println(h.hammingWeight(63));
        System.out.println(Integer.toBinaryString(63));
        System.out.println(h.hammingWeight2(-294967293));
        System.out.println(h.hammingWeight2(294967293));

        String n = "11111111111111111111111111111101";
        System.out.println(Integer.parseUnsignedInt(n,2));
    }
}
