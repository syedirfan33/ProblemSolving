package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int num : map.keySet()) { // this will prevent duplicates
            if (k == 0 && map.get(num) > 1) {
                res++;
            } else if (k > 0 && map.containsKey(num + k)) {
                res++;
            }
        }
        return res;
    }
}
