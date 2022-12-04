package Interviews.paypal;

import java.util.List;

public class FindMaxDistinctItems {

    public int findMaxDistinctItems(int n, int k, List<Integer> arr){
        int l = k, count=0;
        for(int i=1;i<n;i++){
            if(l > 0 && !arr.contains(i)){
                l -= i;
                if(l > 0){
                    count++;
                }
            }
        }
        return count+arr.size();
    }

    public static void main(String[] args) {
        FindMaxDistinctItems f = new FindMaxDistinctItems();
        System.out.println(f.findMaxDistinctItems(10, 10, List.of(1,3,8)));
        System.out.println(f.findMaxDistinctItems(5, 8, List.of(3, 6)));
        System.out.println(f.findMaxDistinctItems(8, 5, List.of(1, 2)));
    }
}
