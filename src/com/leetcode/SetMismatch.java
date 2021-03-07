package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMismatch {
    // Solved it myself optimally
    public int[] findErrorNums(int[] nums) {
        int duplicate = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]) - 1; // to make it zero indexed;
            if (nums[cur] < 0) {
                duplicate = cur + 1;
            }
            if (nums[cur] > 0) nums[cur] = -nums[cur];

        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) return new int[]{duplicate, i + 1};
        }
        return new int[]{-1, -1};
    }
}
