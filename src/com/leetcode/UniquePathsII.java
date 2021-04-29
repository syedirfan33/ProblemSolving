package com.leetcode;

public class UniquePathsII {
    // I solved it
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        if (obstacleGrid[len - 1][col - 1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[len + 1][col + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= col; j++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[len][col];
    }
}
