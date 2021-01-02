package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(); // We can use int array of size 60 too.
        for (int t : time) {
            if (t % 60 == 0) {
                res += map.getOrDefault(0, 0);
            } else {
                res += map.getOrDefault(60 - t % 60, 0);
            }
            map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
        }
        return res;
    }
}
