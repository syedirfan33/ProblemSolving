package com.leetcode;

public class MaximumSwap {
    public int maximumSwap(int num) {
        String a = Integer.toString(num);
        char[] nums = a.toCharArray();
        int n = nums.length;

        char[] max = new char[n];
        max[n - 1] = nums[n - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            max[i] = max[i + 1] > nums[i] ? max[i + 1] : nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max[i]) {
                char temp = nums[i];
                int idx = a.lastIndexOf((max[i]));
                nums[i] = max[i];
                nums[idx] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(nums));
    }
}
