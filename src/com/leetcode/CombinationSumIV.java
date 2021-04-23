package com.leetcode;

import java.util.Arrays;

public class CombinationSumIV {
    // Video from algorithms made easy
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        helper(nums, target, memo);
        return memo[target];
    }

    private int helper(int[] nums, int target, int[] memo) {
        if (memo[target] != -1)
            return memo[target];

        if (target == 0)
            return 1;

        int res = 0;
        for (int num : nums) {
            if (num <= target) {
                res += helper(nums, target - num, memo);
            }
        }
        memo[target] = res;
        return res;
    }
}
