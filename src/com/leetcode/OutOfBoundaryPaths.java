package com.leetcode;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    long[][][] memo;
    int mod = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new long[m][n][maxMove + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return (int) dfs(m, n, maxMove, startRow, startColumn);
    }

    private long dfs(int m, int n, int movesLeft, int curRow, int curCol) {
        if (curRow < 0 || curRow >= m || curCol < 0 || curCol >= n)
            return 1;
        if (movesLeft == 0)
            return 0;
        if (memo[curRow][curCol][movesLeft] != -1)
            return memo[curRow][curCol][movesLeft];

        long cur = 0;
        cur += dfs(m, n, movesLeft - 1, curRow + 1, curCol);
        cur += dfs(m, n, movesLeft - 1, curRow - 1, curCol);
        cur += dfs(m, n, movesLeft - 1, curRow, curCol + 1);
        cur += dfs(m, n, movesLeft - 1, curRow, curCol - 1);
        cur %= mod;
        memo[curRow][curCol][movesLeft] = cur;
        return cur;
    }
}
