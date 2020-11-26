package com.leetcode;

public class MaximumNonNegativeProductInMatrix {
    long res = Integer.MIN_VALUE;

    public int maxProductPath(int[][] grid) {
        if (grid.length == 0) return 0;

        dfs(grid, 0, 0, 1);
        long modulus = (long) Math.pow(10, 9) + 7;

        return res < 0 ? -1 : (int) (res % modulus);
    }

    private void dfs(int[][] grid, int i, int j, long cur) {
        if (i == grid.length && j == grid[0].length || i == grid.length && j == grid[0].length - 1 || i == grid.length - 1 && j == grid[0].length) {
            res = Math.max(cur, res);
            return;
        }
        if (i >= grid.length || j >= grid[0].length) return;
        if (grid[i][j] == 0) {
            res = Math.max(res, 0);
            return;
        }
        cur *= grid[i][j];
        dfs(grid, i + 1, j, cur);
        dfs(grid, i, j + 1, cur);

    }
}
