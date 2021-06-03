package com.practice.leetcode.dp.linearDp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(dpDecodeWays("1234"));
    }

    public static int dpDecodeWays(String str){
        Map<String, Integer> map = new HashMap<>();
        return decodeWays(str, map);
    }

    public static int decodeWays(String str, Map<String,Integer> map){
        int leng = str.length();
        if (leng == 0) {
            return 1;
        }
        if (str.startsWith("0")) {
            return 0;
        }
        String substring = str.substring(1);
        if(!map.containsKey(substring)){
            map.put(substring, decodeWays(substring,map));
        }

        int result = map.get(substring);
        if (leng>=2 && (Integer.parseInt(str.substring(0, 2))) <= 26) {
            String substring1 = str.substring(2);
            if (map.containsKey(substring1)) {
                result += map.get(substring1);
            }else {
                result += decodeWays(substring1,map);
                map.put(substring1,result);
            }
        }
        return result;
    }

    //Not working. Tried to mimic https://www.youtube.com/watch?v=qli-JCrSwuk for perf improvement

    public static int num_ways_dp(String str){
        int[] memo = new int[str.length()+1];
        for(int k=0;k< memo.length;k++){
            memo[k] = -1;
        }
        return helper(str,str.length(), memo);
    }

    public static int helper(String data, int leng, int[] memo){
        if (leng == 0) {
            return 1;
        }
        int ss = data.length()-leng;
        if (String.valueOf(data.charAt(ss)).equalsIgnoreCase("0")) {
            return 0;
        }
        if(memo[leng] != -1){
            return memo[leng];
        }
        int result = helper(data,leng-1, memo);
        if(leng >=2 && (Integer.parseInt(data.substring(0, 2))) <= 26) {
            result += helper(data,leng-2, memo);
        }
        memo[leng] = result;
        return result;
    }
}
