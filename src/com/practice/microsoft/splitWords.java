package com.practice.microsoft;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class splitWords {
    static void splitWords2() throws Exception {
        File file = new File("/Users/harikrishnarudra/IdeaProjects/Learn/src/com/test/microsoft/input.txt");
        List<String> resList = new ArrayList<>();
        int counter = 0;

        try (FileReader fileReader = new FileReader(file)) {
            int length = (int) file.length();
            int total = length / 160;
            if (length % 160 != 0) {
                total += 1;
            }
            while (counter++ * 160 <= length) {
                char[] chars = new char[160];
                int offset = 0;
                while (offset < chars.length) {
                    int result = fileReader.read(chars, offset, chars.length - offset);
                    if (result == -1) {
                        break;
                    }
                    offset += result;
                }
                String res = String.valueOf(chars);
                res += "(" + counter + "/" + total + ")";

                resList.add(res);
                System.out.println(res);
            }
        }
    }

    public static void main(String[] args) {
        try {
            splitWords2();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
