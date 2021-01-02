package com.leetcode;

public class PartitionEqualSubSetSum {
    // This problem is same as sub set sum interview bit problem, watch prakash shukla's video
    public boolean canPartition(int[] nums) {
        int target = 0;
        for (int num : nums) {
            target += num;
        }
        if (target % 2 != 0) return false; // If the no. is odd , we can not divide array equally into two parts
        target = target / 2; // If the target is 22, search if sum can be 11. if it is, for sure remaining sum would also be 11 and hence total sum would be 22
        return subSetSum(nums, target);
    }

    private boolean subSetSum(int[] nums, int target) {
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];
    }
}
