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

    // SLighly compact solution, same idea;
    public int numSquaresII(int n) {
        int[] dp = new int[n + 1];

        for(int i = 1; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
            }
        }
        return dp[n];
    }
}
