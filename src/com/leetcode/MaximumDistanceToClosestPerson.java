package com.leetcode;

public class MaximumDistanceToClosestPerson {
    public int maxDistToClosest(int[] nums) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == 1 && nums[right] == 1) {
                res = Math.max(res, (right - left) / 2);
                left = right;
                right = left + 1;
            } else if (nums[right] == 0) right++;
            else if (nums[left] == 0) {
                res = Math.max(res, right - left);
                left = right;
                right = left + 1;
            }

        }
        if (nums[right - 1] == 0) res = Math.max(res, right - left - 1);
        return res;
    }
}
