package com.leetcode;

public class HouseRobberII {
    public int rob(int[] nums) {
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = 0;
        int second = 0;
        for (int i = start; i <= end; i++) {
            int res = Math.max(nums[i] + first, second);
            first = second;
            second = res;
        }
        return second;
    }
}
