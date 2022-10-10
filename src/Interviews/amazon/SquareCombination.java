package Interviews.amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class SquareCombination {

    public int maxSquareCombination(int[] arr) {
        Map<Integer, List<Set>> map = new TreeMap<>();
        for (int i : arr) {
            SortedSet set = new TreeSet();
            SortedSet possibleSet = new TreeSet();
            int num = i;
            if (isPerfectSquare(num)) {
                num = getPerfectSquare(num);
                if (map.containsKey(num)) {
                    List<Set> sets = map.get(num);
                    final Set actSet = sets.get(0);
                    final Set possSet = sets.get(1);
                    if (possSet.contains(i)) {
                        actSet.add(i);
                        possSet.remove(i);
                    }
                    map.put(num, List.of(actSet, possSet));
                } else {
                    Set actSet = new TreeSet();
                    Set possSet = new TreeSet();
                    actSet.add(i);
                    possSet.add(num);
                    while (isPerfectSquare(num)) {
                        num = getPerfectSquare(num);
                        possSet.add(num);
                    }
                    map.put(num, List.of(actSet, possSet));
                }
            }
        }
        int res = -1;
        final Set<Integer> keySet = map.keySet();
        final Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()){
            final List<Set> sets = map.get(iterator.next());
            final Set<Integer> actSet = sets.get(0);
            if(actSet.size() >= 2){
                int val = largestPosSquare(actSet);
                if( val > res){
                    res = val;
                }
            }
        }
        if(res ==1){
            return -1;
        }
        return res;
    }

    private int largestPosSquare(Set<Integer> set){
        int count = 0, maxCount = 0;
        int prev = -1;
        final Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int ele = iterator.next();
            if(prev != -1) {
                if(prev*prev == ele){
                    count++;
                    if (count > maxCount) {
                        maxCount = count;
                    }
                }else{
                    count=1;
                }
                prev = ele;
            }else{
                count++;
                if (count > maxCount) {
                    maxCount = count;
                }
            }
        }
        return maxCount;

    }

    private boolean isPerfectSquare(int n) {
        int x = (int) Math.sqrt(n);
        if (x * x == n) {
            return true;
        }
        return false;
    }

    private int getPerfectSquare(int n){
        int x = (int) Math.sqrt(n);
        if(x*x==n){
            return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        SquareCombination s = new SquareCombination();
        System.out.println(s.maxSquareCombination(new int[]{625,4,2,5,25}));
    }
}
