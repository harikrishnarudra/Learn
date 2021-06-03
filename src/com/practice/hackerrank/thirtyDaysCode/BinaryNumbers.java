package com.practice.hackerrank.thirtyDaysCode;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


public class BinaryNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n=0;
        while (n!=-1){
            n = Integer.parseInt(bufferedReader.readLine().trim());
            System.out.println(maxConsBinaryNums(n));
        }
        bufferedReader.close();
    }

    private static int maxConsBinaryNums(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int maxCnt = 0;
        if (n >= 3) {
            Stack<Integer> stack = new Stack();
            while (n > 0) {
                int rem = n % 2;
                n = n / 2;
                stack.push(rem);
            }
            int cnt = 0;
            while (!stack.isEmpty()) {
                int d = stack.pop();
                if (d == 1) {
                    cnt += 1;
                }
                if (d == 0) {
                    cnt = 0;
                }
                if (cnt > maxCnt) {
                    maxCnt = cnt;
                }
            }
        }
        return maxCnt;
    }
}

