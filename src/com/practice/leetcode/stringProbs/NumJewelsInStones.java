package com.practice.leetcode.stringProbs;

import java.util.HashMap;
import java.util.Map;

public class NumJewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character,Integer> jewelMap = new HashMap<>();
        for(char c:jewels.toCharArray()){
            jewelMap.put(c,1);
        }
        int res = 0;
        for(char s:stones.toCharArray()){
            res += jewelMap.getOrDefault(s,0);
        }
        return res;
    }

    /**
     * I liked this way of doing
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        int[] cnt = new int[128];
        for (char c : S.toCharArray())
            cnt[c]++;
        int ans = 0;
        for (char c : J.toCharArray())
            ans += cnt[c];
        return ans;
    }

    public static void main(String[] args) {
        NumJewelsInStones n = new NumJewelsInStones();
        System.out.println(n.numJewelsInStones("aA","aAAbbBB"));
    }
}
