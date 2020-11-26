package com.leetcode;

public class LongestMountainInArray {
    public int longestMountain(int[] nums) {
        int len = nums.length;
        if (len <= 2) return 0;
        int left = 1;
        int res = 0;
        while (left < len) {
            if (nums[left] <= nums[left - 1]) {
                left++;
                continue;
            }
            int cur = left - 1;
            while (left < len && nums[left] > nums[left - 1]) {
                left++;
            }
            boolean isMountain = false;
            while (left < len && nums[left] < nums[left - 1]) {
                isMountain = true;
                left++;
            }
            if (isMountain) res = Math.max(left - cur, res);
        }
        return res;
    }
}
