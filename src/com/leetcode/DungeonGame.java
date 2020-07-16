package com.leetcode;

/**
 * @author Syed Irfan - 21/06/2020
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int columns = dungeon[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < columns + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[rows - 1][columns] = 1;
        dp[rows][columns - 1] = 1;
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                if (dp[i][j] <= 0) dp[i][j] = 1;
            }
        }
        return dp[0][0];
    }
}
