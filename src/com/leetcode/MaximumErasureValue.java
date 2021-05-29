package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    // Same idea as longest substr without repeating characters, video from coding decoded
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0, res = 0, runningSum = 0;
        while (right < nums.length) {
            int cur = nums[right];
            if (!set.contains(cur)) {
                set.add(cur);
                runningSum += cur;
                res = Math.max(res, runningSum);
                right++;
            } else {
                set.remove(nums[left]);
                runningSum -= nums[left];
                left++;
            }
        }
        return res;
    }
}
