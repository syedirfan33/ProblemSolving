package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE, res = 0;
        int first = 0, second = 1;
        for (int i = 0; i + 2 < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (Math.abs(target - sum) < Math.abs(diff)) {
                    diff = target - sum;
                    res = sum;
                }
                if (diff == 0) break;
                if (sum > target) high--;
                else low++;
            }
        }
        return res;
    }
}
