package com.practice.leetcode.ggle;

public class NumIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m<=0) return 0;
        int n = grid[0].length;
        int numIslands = 0;
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
                if(grid[x][y] == '1'){
                    numIslands++;
                    markAdjs(grid, x, y, m, n);
                }
            }
        }
        return numIslands;
    }

    private void markAdjs(char[][] grid, int x, int y, int m, int n){
        if (x < 0 || y < 0 || x > m - 1 || y > n - 1 || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '2';
        markAdjs(grid, x + 1, y, m, n);
        markAdjs(grid, x, y + 1, m, n);
        markAdjs(grid, x - 1, y, m, n);
        markAdjs(grid, x, y - 1, m, n);
    }

    public static void main(String[] args) {
        NumIslands n = new NumIslands();
        char[][] grid = {{'1', '1', '0', '0', '0'},{'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(n.numIslands(grid));
        System.out.println("============");

        grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(n.numIslands(grid));
    }
}
