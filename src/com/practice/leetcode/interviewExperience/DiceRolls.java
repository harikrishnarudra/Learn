package com.practice.leetcode.interviewExperience;

import java.util.Arrays;

public class DiceRolls {
    public int[] diceRolls(int[] A, int F, int mean){
        int sum = 0, N=A.length;
        for(int i:A){
            sum += i;
        }
        int remaining = mean*(N+F)-sum;
        if(remaining > F*6 || remaining<=0 || remaining < F ){
            return new int[]{0};
        }
        int[] result = new int[F];
        Arrays.fill(result, 1);
        remaining -= F;
        for(int i=0;i<F;i++){
            int canAddVal = Math.min(remaining, 5);
            remaining -= canAddVal;
            result[i] += canAddVal;
            if(remaining==0){
                break;
            }
        }
        return result;
    }

    public int[] diceRollsNotWithOnesAsResult(int[] A, int F, int mean) {
        int sum = 0 ;
        for (int i : A) {
            sum += i;
        }
        int remaining = mean * (A.length + F) - sum;
        if (remaining > F * 6 || remaining <= 0 || remaining < F) {
            return new int[]{0};
        }
        int[] result = new int[F];

        int p = remaining/F;
        int q = remaining%F;

        for (int i = 0; i < F; i++) {
            result[i] = p+(q>0? 1:0);
            q--;
        }
        return result;
    }

    public static void main(String[] args) {
        DiceRolls d = new DiceRolls();
        int[] res = d.diceRollsNotWithOnesAsResult(new int[]{3,2,4,3},2,4 );
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("==========");
        res = d.diceRollsNotWithOnesAsResult(new int[]{1, 5, 6}, 4, 3);
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("==========");
        res = d.diceRollsNotWithOnesAsResult(new int[]{1, 2, 3, 4}, 4, 6);
        Arrays.stream(res).forEach(System.out::println);
        System.out.println("==========");
        res = d.diceRollsNotWithOnesAsResult(new int[]{6, 1}, 1, 1);
        Arrays.stream(res).forEach(System.out::println);
    }
}
