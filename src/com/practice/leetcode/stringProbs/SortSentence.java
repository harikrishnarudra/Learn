package com.practice.leetcode.stringProbs;

/**
 * 1859. Sorting the Sentence
 * A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of lowercase and uppercase English letters.
 *
 * A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the words in the sentence.
 *
 * For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2 sentence4 This1 a3".
 * Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original sentence.
 *
 * Example 1:
 *
 * Input: s = "is2 sentence4 This1 a3"
 * Output: "This is a sentence"
 * Explanation: Sort the words in s to their original positions "This1 is2 a3 sentence4", then remove the numbers.
 * Example 2:
 *
 * Input: s = "Myself2 Me1 I4 and3"
 * Output: "Me Myself and I"
 * Explanation: Sort the words in s to their original positions "Me1 Myself2 and3 I4", then remove the numbers.
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 200
 * s consists of lowercase and uppercase English letters, spaces, and digits from 1 to 9.
 * The number of words in s is between 1 and 9.
 * The words in s are separated by a single space.
 * s contains no leading or trailing spaces.
 */
public class SortSentence {

    /**
     * Second session - Best performant
     *
     * @param s
     * @return
     */
    public static String sortSentence3(String s) {
        char[] s1 = s.toCharArray();
        String[] words = new String[9];
        int i=0, j=-1;
        for (int ind = 0; ind<s1.length; ind++) {
            if(s1[ind] > '0' && s1[ind]<'9'){
                words[s1[ind]-'0'-1] = s.substring(j+1, i);
                j=i++;
            }else{
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String w : words) {
            if(w!=null) {
                stringBuilder.append(w.trim());
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
    /**
     * Second session
     * @param s
     * @return
     */
    public static String sortSentence2(String s) {
        String[] s1 = s.split(" ");
        String[] words = new String[s1.length];
        for(String ss:s1){
            int leng = ss.length();
            int ind = Character.getNumericValue(ss.charAt(leng - 1));
            String word = ss.substring(0, leng - 1);
            words[ind-1] = word;
        }
        String join = String.join(" ", words);
        return join;
    }

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
        System.out.println(sortSentence3("is2 sentence4 This1 a3"));
        System.out.println(sortSentence3("Myself2 Me1 I4 and3"));
        System.out.println(sortSentence3("is1 sentence2 This3 a4"));
    }
}
