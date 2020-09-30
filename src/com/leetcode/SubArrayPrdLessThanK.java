package com.leetcode;

public class SubArrayPrdLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0;
        int prd = 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            prd *= nums[right];
            while (prd >= k) {
                prd /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
