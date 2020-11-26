package com.leetcode;

import java.util.Arrays;

public class FIndSmallestDivisorGivenThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        // Note that as the nums[i] increases, sum decreases. Hence we can use binary search
        int left = 1, right = nums[nums.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = getSum(mid, nums);
            if (sum > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int getSum(int i, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num % i == 0 ? num / i : (num / i) + 1; // We could use Math.ceil, but it's a little bit slow
        }
        return sum;
    }
}
