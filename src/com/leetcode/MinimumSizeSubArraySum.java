package com.leetcode;

public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (s == 0 || nums.length == 0) return 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res != Integer.MAX_VALUE ? res : 0;
    }
}
