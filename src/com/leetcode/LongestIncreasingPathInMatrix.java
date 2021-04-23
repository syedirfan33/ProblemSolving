package com.leetcode;

public class LongestIncreasingPathInMatrix {
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int cur = dfs(matrix, i, j);
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] > 0)
            return memo[i][j];

        int max = 1;
        for (int[] dir : dirs) {
            int nextX = i + dir[0];
            int nextY = j + dir[1];
            if (nextX >= 0 && nextX < matrix.length && nextY >= 0 && nextY < matrix[0].length && matrix[nextX][nextY] > matrix[i][j]) {
                int len = 1 + dfs(matrix, nextX, nextY);
                max = Math.max(max, len);
            }
        }
        memo[i][j] = max;
        return max;
    }
}
