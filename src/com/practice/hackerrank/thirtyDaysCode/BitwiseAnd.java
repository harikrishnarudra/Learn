package com.practice.hackerrank.thirtyDaysCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class BitwiseAnd {

    /*
     * Complete the 'bitwiseAnd' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER K
     */

    public static int bitwiseAnd(int N, int K) {
        // Write your code here
        int j = 1;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < N; i++) {
            j = i + 1;
            while (j <= N) {
                int y = i&j;
                if (y < K && y>maxVal) {
                    maxVal=y;
                }
                j++;
            }
        }
        return maxVal;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int count = Integer.parseInt(firstMultipleInput[0]);

                int lim = Integer.parseInt(firstMultipleInput[1]);

                int res = BitwiseAnd.bitwiseAnd(count, lim);

                System.out.println(String.valueOf(res));
//                bufferedWriter.write(String.valueOf(res));
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }
}

