package Interviews.experian_techgig;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CandidateCode {
    public List<Integer> absentees(int n, int[] nums){
        List<Integer> l = new ArrayList<>();
        int[] res = new int[n+1];
        for(int i=0;i<n;i++){
            res[nums[i]] = 1;
        }
        for(int i=1;i<n+1;i++){
            if(res[i]==0){
                l.add(i);
            }
        }
        return l;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = s.nextInt();
        int[] nums = new int[n + 1];
        System.out.println("Enter nums : ");
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        CandidateCode c = new CandidateCode();
        List<Integer> vals = c.absentees(n, nums);
        vals.stream().forEach(System.out::println);
    }
}
