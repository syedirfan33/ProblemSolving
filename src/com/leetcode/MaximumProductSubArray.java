package com.leetcode;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {
        int max_overall = nums[0], max_cur = nums[0], min_cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_cur;
            max_cur = Math.max(nums[i], Math.max(nums[i] * max_cur, nums[i] * min_cur));
            min_cur = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * min_cur));
            max_overall = Math.max(max_overall, max_cur);
        }
        return max_overall;
    }
}
