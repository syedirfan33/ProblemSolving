/**
 *
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class IslandPerimeter {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int neighbours = get(i, j - 1, grid) + get(i - 1, j, grid) + get(i + 1, j, grid) + get(i, j + 1, grid);
                    int val = 4 - neighbours;
                    res = res + val;
                }
            }
        }
        return res;
    }
    
    private int get(int row, int column, int[][] grid) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) return 0;
        return grid[row][column];
    }
}