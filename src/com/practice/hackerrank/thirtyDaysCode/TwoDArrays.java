package com.practice.hackerrank.thirtyDaysCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util .*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class TwoDArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        hourGlass(arr);
    }


    //WORKING
    private static void hourGlass(List<List<Integer>> arr){
        int maxSum = Integer.MIN_VALUE;
        int rows = arr.size();
        int cols = arr.get(0).size();
        for(int i=0;i<rows-2;i++){
            for(int j=0;j<cols-2;j++){
                int sumVal = arr.get(i).get(j)+ arr.get(i).get(j+1) + arr.get(i).get(j+2)
                        + arr.get(i+1).get(j+1)
                        + arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);
                maxSum = Math.max(maxSum, sumVal);
            }
        }
        System.out.println(maxSum);
    }

//    Worked Solution
    private static void hourGlass2(List<List<Integer>> arr) {
        int maxSum = 0;
        int rows = arr.size();
        int cols = arr.get(0).size();
        int sum[] = new int[16];
        int h = 0;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < cols - 2; j++) {
                sum[h] = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                h++;
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[15]);
    }
}

