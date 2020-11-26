package com.leetcode;

public class MinimumValueToGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int val = 0;
        for (int num : nums) {
            val += num;
            min = Math.min(val, min);
        }
        return min > 0 ? 1 : Math.abs(min) + 1;
    }
}
