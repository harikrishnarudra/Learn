package com.practice.leetcode.backtrack;

import java.util.HashSet;
import java.util.Set;

public class NQueensCount {
    private int size;
    private char[][] board;
    private Set<Integer> cols = new HashSet<>();
    private Set<Integer> diag = new HashSet<>();
    private Set<Integer> antidiag = new HashSet<>();
    public int totalNQueens(int n) {
        size = n;
        board = new char[size][size];
        for(int i=0; i< n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        return backTrack(0, 0);
    }

    private int backTrack(int row, int count){
        for (int col = 0; col < size; col++) {
            if (isNotUnderAttack(row, col)){
                placeQueen(row, col);
                if(row+1 == size){
                    count +=1;
                }else{
                    count = backTrack(row+1, count);
                }
                removeQueen(row, col);
            }
        }
        return count;
    }

    private boolean isNotUnderAttack(int row, int col){
        if(!cols.contains(col) && !diag.contains(row+col) && !antidiag.contains(row-col)){
            return true;
        }
        return false;
    }

    private void placeQueen(int row, int col){
        board[row][col] = 'Q';
        cols.add(col);
        diag.add(row+col);
        antidiag.add(row-col);
    }
    private void removeQueen(int row, int col){
        board[row][col] = '.';
        cols.remove(col);
        diag.remove(row + col);
        antidiag.remove(row - col);
    }

    public static void main(String[] args) {
        NQueensCount n = new NQueensCount();
        System.out.println(n.totalNQueens(1));
    }
}
