package com.practice.leetcode.stringProbs;

public class GoalParser {
    public String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
