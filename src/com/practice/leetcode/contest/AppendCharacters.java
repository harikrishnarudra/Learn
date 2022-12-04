package com.practice.leetcode.contest;

public class AppendCharacters {
    public int appendCharacters(String s, String t) {
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        int k = 0, i = 0;
        for(;i<sarr.length && k<tarr.length;i++){
            if(sarr[i] == tarr[k]){
                k++;
            }
        }
        return tarr.length-k;
    }

    public static void main(String[] args) {
        AppendCharacters a = new AppendCharacters();
        System.out.println(a.appendCharacters("coacdding", "coding"));
        System.out.println(a.appendCharacters("coaching", "coding"));
        System.out.println(a.appendCharacters("a", "coding"));
        System.out.println(a.appendCharacters("abcde", "a"));
    }
}
