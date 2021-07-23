package com.practice.hackerrank.thirtyDaysCode;

import java.util.Scanner;

public class Primality {

    public static String findPrimality(String num){
        String result = "Not prime";
        if(Long.parseLong(num)<=1){
            return result;
        }
        if (Long.parseLong(num) == 2 || Long.parseLong(num) == 3) {
            return "Prime";
        }
        if(Long.parseLong(num)%2==0){
            return result;
        }
        if(Long.parseLong(num) >10){
            int sqrt = (int) Math.sqrt(Double.parseDouble(num));
            for(int i=3;i<=sqrt;i+=2){
                if(Long.parseLong(num) % i == 0) {
                    return result;
                }
            }
            return "Prime";
        }
        else{
            int n = Integer.parseInt(num);
            for(int i=2;i<n/2;i++){
                if(n%i==0){
                    return result;
                }
            }
            return "Prime";
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            String value  = scanner.next();
            System.out.println(findPrimality(value));
        }
    }
}
