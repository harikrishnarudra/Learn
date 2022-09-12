package com.practice.leetcode.backtrack;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.Set;

public class RobotCleanRoom {
    int[][] directions = {{-1,0},{0,1},{1,0},{0, -1}};
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    Robot robot;

    public void goBack(){
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    public void backTrack(int row, int col, int d){
        visited.add(new ImmutablePair<>(row, col));
        robot.clean();
        for(int i=0;i<4;i++){
            int newD = (i+d)%4;
            int newRow = row + directions[newD][0];
            int newCol = col + directions[newD][1];
            if(!visited.contains(new ImmutablePair<>(newRow,newCol)) && robot.move()){
                backTrack(newRow, newCol, newD);
                goBack();
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot){
        this.robot = robot;
        backTrack(0,0,0);
    }

}
