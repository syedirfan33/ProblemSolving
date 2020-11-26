package com.leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int l = nums.length;
        if (l <= 1) return l;
        int res = Integer.MIN_VALUE;
        int[] dp = new int[l];
        Arrays.fill(dp, 1);
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res == Integer.MIN_VALUE ? 1 : res;
    }
}
