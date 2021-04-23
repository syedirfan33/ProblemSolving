package com.leetcode;

public class MaximumAverageSubArray {
    public double findMaxAverage(int[] nums, int k) {
        int init = 0;
        for (int i = 0; i < k; i++) {
            init += nums[i];
        }
        int res = init;
        for (int i = k; i < nums.length; i++) {
            init -= nums[i - k];
            init += nums[i];
            res = Math.max(res, init);
        }
        return res / (k * (1.0));
    }
}
