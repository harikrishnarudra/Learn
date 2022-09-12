package com.practice.leetcode.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {
    private int size;
    private List<List<String>> solutions = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        size = n;
        char[][] emptyBoard = new char[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                emptyBoard[i][j] = '.';
            }
        }
        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private List<String> createBoard(char[][] board){
        List<String> boardState = new ArrayList<>();
        for(int row = 0; row < size ; row++){
            String currentRow = new String(board[row]);
            boardState.add(currentRow);
        }
        return boardState;
    }

    private void backtrack(int row, Set<Integer> diagnols, Set<Integer> antiDiagnols, Set<Integer> cols,
                           char[][] board){
        //BaseCase
        if(row ==  size){
            solutions.add(createBoard(board));
            return;
        }
        for(int col=0; col < size; col++){
            int currDiagonal = row - col;
            int antiDiagonal = row + col;
            if(cols.contains(col) || diagnols.contains(currDiagonal) || antiDiagnols.contains(antiDiagonal)){
                continue;
            }
            cols.add(col);
            diagnols.add(currDiagonal);
            antiDiagnols.add(antiDiagonal);
            board[row][col] = 'Q';

            backtrack(row+1 , diagnols, antiDiagnols, cols, board);

            cols.remove(col);
            diagnols.remove(currDiagonal);
            antiDiagnols.remove(antiDiagonal);
            board[row][col] = '.';

        }
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        for(int i=0;i<lists.size();i++){
            for(int j=0;j<lists.get(0).size(); j++){
                System.out.print(lists.get(i).get(j));
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
