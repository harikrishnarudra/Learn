package com.practice.leetcode.stringProbs;

/**
 * 1662. Check If Two String Arrays are Equivalent
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *
 * A string is represented by an array if the array elements concatenated in order forms the string.
 *
 * Example 1:
 *
 * Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 * Output: true
 * Explanation:
 * word1 represents string "ab" + "c" -> "abc"
 * word2 represents string "a" + "bc" -> "abc"
 * The strings are the same, so return true.
 * Example 2:
 *
 * Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 * Output: false
 * Example 3:
 *
 * Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * Output: true
 */
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

    /**https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/discuss/967572/Java-4-pointers-and-Iterator-Solution-Doing-it-in-O(1)-space-is-the-trick
     *
     * @param word1
     * @param word2
     * @return
     */
    public static boolean arrayStringsAreEqualWithChars(String[] word1, String[] word2) {
        if (word1 == null || word2 == null) {
            return false;
        }
        int i=0, j=0;
        int p=0, q=0;
        while (i< word1.length && j< word2.length){
            String firArrWord = word1[i];
            String secArrWord = word2[j];

            if(firArrWord.charAt(p)!=secArrWord.charAt(q)) return false;
            if(p<firArrWord.length()-1){
                p++;
            }else{
                p=0;
                i++;
            }

            if (q < secArrWord.length() - 1) {
                q++;
            } else {
                q = 0;
                j++;
            }
        }
        return i == word1.length && j == word2.length;
    }
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqualWithChars(new String[]{"ab","c"}, new String[]{"a","bc"}));
        System.out.println(arrayStringsAreEqualWithChars(new String[]{"abc"}, new String[]{"a", "bc"}));
        System.out.println(arrayStringsAreEqualWithChars(new String[]{"abc"}, new String[]{"a", "bc","d"}));
        System.out.println(arrayStringsAreEqualWithChars(new String[]{"ab","c"}, new String[]{"abc"}));
        System.out.println(arrayStringsAreEqualWithChars(new String[]{"ab", "c"}, new String[]{"abc"}));
    }
}

