package com.practice.leetcode.stringProbs;

public class ArrayStringsAreEqual {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if(word1==null || word2==null){
            return false;
        }
        String w1="", w2="";
        for(String w:word1){
            w1 +=w;
        }
        for (String w : word2) {
            w2 += w;
        }
        return w1.equals(w2);
    }

    public static boolean arrayStringsAreEqualWithStrB(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        StringBuffer strBuffer1 = new StringBuffer();
        StringBuffer strBuffer2 = new StringBuffer();

        for (String w : word1) {
            strBuffer1.append(w);
        }
        for (String w : word2) {
            strBuffer2.append(w);
        }
        String w1 = strBuffer1.toString(), w2 = strBuffer2.toString();
        return w1.equals(w2);
    }

    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab","c"}, new String[]{"a","bc"}));
    }
}

