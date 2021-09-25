package com.leetcode;

public class MaxConsecutiveOnesIII {
    // Video from coding decoded, used my little brain as well
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;

        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                if (k > 0) {
                    right++;
                    k--;
                } else {
                    while (nums[left] == 1) left++;
                    left++;
                    k++;
                }
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
