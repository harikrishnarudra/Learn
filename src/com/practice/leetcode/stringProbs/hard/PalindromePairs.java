package com.practice.leetcode.stringProbs.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 336. Palindrome Pairs
 * Hard
 *
 * Given a list of unique words, return all the pairs of the distinct indices (i, j) in the given list, so that the concatenation of the two words words[i] + words[j] is a palindrome.

 * Example 1:
 *
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 * Example 2:
 *
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 *
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 */
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Character, List<String>> lastCharMap = new HashMap<>();
        int n = words.length;
        for(int i=0;i<n;i++){
            String word = words[i];
            if(!word.isEmpty()){
                char firstChar = word.charAt(0);
                char lastChar = word.charAt(word.length()-1);
                if (lastCharMap.containsKey(lastChar)) {
                    List<String> entry = lastCharMap.get(lastChar);
                    if (checkPalindrome(word + entry.get(0))) {
                        res.add(List.of(i, Integer.parseInt(entry.get(1))));
                    }
                    if (checkPalindrome(entry.get(0) + word)) {
                        res.add(List.of(Integer.parseInt(entry.get(1)), i));
                    }
                }
                if(lastCharMap.containsKey(firstChar)){
                    List<String> entry = lastCharMap.get(firstChar);
                    if(checkPalindrome(word + entry.get(0))){
                        res.add(List.of(i, Integer.parseInt(entry.get(1))));
                    }
                    if (checkPalindrome(entry.get(0) + word)) {
                        res.add(List.of(Integer.parseInt(entry.get(1)), i));
                    }
                }
                else{
                    lastCharMap.put(lastChar, List.of(word, String.valueOf(i)));
                }
            }else{
                for(int k=0;k<n;k++){
                    if(i!=k){
                        if (checkPalindrome(words[k])) {
                            res.add(List.of(i, k));
                            res.add(List.of(k, i));
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean checkPalindrome(String res){
        int i=0, j = res.length()-1;
        while (i<j){
            if(res.charAt(i++) != res.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePairs p = new PalindromePairs();
        /*System.out.println(p.checkPalindrome("a"+""));
        System.out.println(p.checkPalindrome("abcd"+"dcba"));
        System.out.println(p.checkPalindrome("lls"+"s"));
        System.out.println(p.checkPalindrome("s" + "sll"));
        System.out.println(p.checkPalindrome("s" + "lls"));*/
        List<List<Integer>> lists = p.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"});
        lists.stream().forEach(integers -> integers.stream().forEach(System.out::println));
        System.out.println("============");
        lists = p.palindromePairs(new String[]{"bat", "tab", "cat"});
        lists.stream().forEach(integers -> integers.stream().forEach(System.out::println));
        System.out.println("============");
        lists = p.palindromePairs(new String[]{"a", ""});
        lists.stream().forEach(integers -> integers.stream().forEach(System.out::println));
        System.out.println("============");
        lists = p.palindromePairs(new String[]{"a", "abc", "aba", ""});
        lists.stream().forEach(integers -> integers.stream().forEach(System.out::println));
        System.out.println("============");
        lists = p.palindromePairs(new String[]{"a", "b", "c", "ab", "ac", "aa"});
        lists.stream().forEach(integers -> integers.stream().forEach(System.out::println));
    }
}
