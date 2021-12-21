package Interviews.informatica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortHashMapByValues {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 4);
        map.put("c", 5);
        map.put("d", 2);
        Collection<Integer> values = map.values();
        List<Integer> ll = new ArrayList<>();
        ll.addAll(values);
        Collections.sort(ll);

        /*values.stream().sorted()
                .forEach(v ->map.)*/
    }
}
