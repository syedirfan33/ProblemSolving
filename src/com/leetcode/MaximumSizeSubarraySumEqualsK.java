package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {
    //Facebook question, premium
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int sum = 0;
        map.put(0, -1); // consider [1, 2, 3, 4] and k = 10
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // sum - k gives integers with sum = k from index i to j. Think carefully
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            map.putIfAbsent(sum, i);
        }
        return res;
    }
}
