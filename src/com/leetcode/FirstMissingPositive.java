package com.leetcode;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int posi = nums[i] - 1;
            while (nums[i] >= 1 && nums[i] <= n && nums[posi] != posi + 1) {
                swap(nums, posi, i);
                posi = nums[i] - 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int posi, int i) {
        int temp = nums[posi];
        nums[posi] = posi + 1;
        nums[i] = temp;
    }
}
