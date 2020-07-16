package com.leetcode;

/**
 * @author Syed Irfan - 28/06/2020
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            int sq = 1;
            while (sq <= i) {
                min = Math.min(min, 1 + dp[i - sq]);
                j++;
                sq = j * j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
