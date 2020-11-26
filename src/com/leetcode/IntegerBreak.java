package com.leetcode;

public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i; j++) { // we can even reduce second loop to j <= i / 2
                int num1 = Math.max(dp[j], j);
                int num2 = Math.max(dp[i - j], i - j);
                max = Math.max(max, num1 * num2);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
