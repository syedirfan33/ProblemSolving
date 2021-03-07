package com.leetcode;

public class MissingNumber {
    // My solution, but can be solved using n * (n + 1 ) / 2 formula
    public int missingNumber(int[] nums) {
        for (int num : nums) {
            int idx = num == Integer.MIN_VALUE ? 0 : Math.abs(num);
            if (idx >= nums.length) continue;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
            else if (nums[idx] == 0) nums[idx] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        return nums.length;
    }

    public int missingNumberII(int[] nums) {
        int expected = nums.length * (nums.length + 1) / 2;
        int current = 0;
        for (int num : nums) current += num;
        return expected - current;
    }

    private int testMethod(){
        StringBuilder sb = new StringBuilder();

        return 0;
    }
}
