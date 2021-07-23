package com.practice.hackerrank.thirtyDaysCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Regex {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> list = new ArrayList<>();
        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];


                Pattern compile = Pattern.compile("([a-z]+)@([a-z]*)gmail.com");
                Matcher matcher = compile.matcher(emailID);
                if(matcher.matches()){
                    list.add(firstName);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        Collections.sort(list);
        for (String name:list) {
            System.out.println(name);
        }
        System.out.println();
        bufferedReader.close();
    }
}
