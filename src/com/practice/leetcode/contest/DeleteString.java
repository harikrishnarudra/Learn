package com.practice.leetcode.contest;

public class DeleteString {
    public int deleteString(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        int len = s.length();
        int i=0, iLast = 0;
        int j=0, jLast = 0;
        String iString = "";
        while(i < len){
            if(iString != ""){
                if(!iString.contains(String.valueOf(s.charAt(i)))){
                    i++;
                    iString = s.substring(iLast, i);
                }else{
                    int charLen = i-iLast;
                    if((i + charLen) < len && s.substring(i, i+charLen).equalsIgnoreCase(iString)){
                        result++;
                        iLast = i;
                        iString = "";
                    }else{
                        i++;
                        iString = s.substring(iLast, i);
                    }
                }
            }else{
                i++;
                iString = s.substring(iLast, i);
            }
        }
        if(iString != ""){
            result++;
        }
        return result;
    }


    public static void main(String[] args) {
        DeleteString deleteString = new DeleteString();
//        System.out.println(deleteString.deleteString("abcabcdabc"));
        System.out.println(deleteString.deleteString("aaabaab"));
        System.out.println(deleteString.deleteString("aaaaa"));
    }
}
