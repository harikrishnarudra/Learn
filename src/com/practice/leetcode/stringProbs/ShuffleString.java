package com.practice.leetcode.stringProbs;

import java.util.PriorityQueue;
import java.util.Queue;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        int len = indices.length;
        char[] chars = s.toCharArray();
        for(int i=0;i<len;i++){
            int iterativeInd = indices[i];
            while (iterativeInd != i){
                char temp = s.charAt(iterativeInd);
                chars[iterativeInd] = chars[i];
                chars[i] = temp;

                int tempInd = indices[iterativeInd];
                indices[iterativeInd] = indices[i];
                indices[i] = tempInd;

                iterativeInd = indices[i];
            }
        }
        return String.valueOf(chars);
    }

    public static String restoreString2(String s, int[] indices) {
        int len = indices.length;
        char[] result = new char[len];
        for (int i = 0; i < len; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return String.valueOf(result);
    }

    public static String restoreStringWithPQ(String s, int[] indices) {
        Queue<PQElement> p = new PriorityQueue<PQElement>();
        for(int i=0;i<s.length();i++){
            p.add(new PQElement(s.charAt(i),indices[i]));
        }
        String res="";
        while (!p.isEmpty()){
            PQElement element = p.poll();
            res += element.getC();
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(restoreStringWithPQ("aiohn",new int[]{3,1,4,2,0}));
        System.out.println(restoreString2("aiohn", new int[]{3, 1, 4, 2, 0}));
        System.out.println(restoreString2("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
        System.out.println(restoreString("art", new int[]{1, 0, 2}));
        System.out.println(restoreString("abc", new int[]{0,1,2}));
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}

class PQElement implements Comparable<PQElement>{

    private char c;

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    private int ind;

    public PQElement(char c, int index){
        this.c = c;
        this.ind = ind;
    }

    @Override
    public int compareTo(PQElement o) {
        return this.ind > o.ind ? 1: -1;
    }
}