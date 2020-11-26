package com.leetcode;

public class LongestSubarrayOf1s {
    public int longestSubarray(int[] nums) {
        if (nums.length <= 0) return 0;
        int res = -1;
        int max = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) nums[i] += nums[i - 1];
            else {
                int temp = res;
                res += nums[i - 1];
                max = Math.max(res, max);
                res -= temp;
            }
        }

        if (nums[nums.length - 1] > 0) max = Math.max(max, res + nums[nums.length - 1]);
        return max == nums.length ? max - 1 : max;
    }
}
