package com.leetcode;

import java.util.Arrays;

public class RodCutting {
    // This problem is not on leetcode, but similar to "Integer Break"
    // Given length of rod N to be cut into smller pieces. prices[i] , i from 0 n - 1 represent cost to cut rod at length n + 1
    // Determine maximum profit
    //ex, n = 4, prices = [1, 5, 8, 9] ans = 10 ((2,2) - rod length, (5+5) - cost)
    public static int cutRod(int n, int[] prices){
        int[] dp = new int[n + 1];
        dp[1] = prices[0];
        for(int i = 2; i <=n; i++){
            int max = prices[i - 1];
            for(int j = 1; j < i; j++){
                int cost1 = dp[j];
                int cost2 = Math.max(dp[i - j], prices[i - j - 1]);
                max = Math.max(max, cost1 + cost2);
            }
            dp[i] = max;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cutRod(4, new int[]{1,5,8,9}));
    }
}
