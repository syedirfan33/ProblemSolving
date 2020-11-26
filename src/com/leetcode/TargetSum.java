package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TargetSum {

    Map<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S, 0);
    }

    int helper(int[] nums, int idx, int target, int cur) {
        if (idx == nums.length) {
            if (target == cur) return 1;
            else return 0;
        }
        String key = idx + "-" + cur;
        if (memo.containsKey(key)) return memo.get(key);
        int count = 0;
        count += helper(nums, idx + 1, target, cur + nums[idx]);
        count += helper(nums, idx + 1, target, cur - nums[idx]);
        memo.put(key, count);
        return count;
    }
}
