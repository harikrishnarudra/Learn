package Interviews.paypal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class GetSearchResults {
    public List<List<String>> getSearchResults(List<String> words, List<String> queries){
        List<List<String>> result = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for (String word : words) {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            final Set<String> treeSet = map.getOrDefault(sortedStr, new TreeSet<>());
            treeSet.add(word);
            map.put(sortedStr, treeSet);
        }
        for (String word : queries) {
            final char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            final Set<String> stringList = map.getOrDefault(sortedStr, new TreeSet<>());
            result.add(new ArrayList<>(stringList));
        }
        return result;
    }

    public static void main(String[] args) {
        GetSearchResults g = new GetSearchResults();
        System.out.println(g.getSearchResults(List.of("allot","cat","peach","dusty", "act", "cheap"), List.of("tac","study","peach")));
    }
}
