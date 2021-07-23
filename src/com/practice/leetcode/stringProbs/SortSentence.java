package com.practice.leetcode.stringProbs;

public class SortSentence {
    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        int len = words.length;
        String[] result = new String[len];
        for (int i = 0; i < len; i++) {
            String word = words[i];
            char ind = word.charAt(word.length()-1);
            word = word.replace(ind, ' ');
            result[ind-'0' - 1] = word;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String w:result) {
            stringBuilder.append(w);
        }
        return stringBuilder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
        System.out.println(sortSentence("is1 sentence2 This3 a4"));
    }
}
