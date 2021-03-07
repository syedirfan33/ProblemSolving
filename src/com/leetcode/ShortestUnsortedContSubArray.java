package com.leetcode;

public class ShortestUnsortedContSubArray {
    // NICK WHITE'S VIDEO OR OFFICIAL SOL
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean sorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
            }
            if (!sorted) min = Math.min(min, nums[i]);
            ;
        }
        sorted = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                sorted = false;
            }
            if (!sorted) max = Math.max(max, nums[i]);
            ;
        }
        int l, r;
        for (l = 0; l < nums.length; l++) {
            if (nums[l] > min) break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (nums[r] < max) break;
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
}
