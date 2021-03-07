package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        int len = candyType.length / 2;
        for (int num : candyType) {
            set.add(num);
            if (set.size() >= len) break; // To make it a bit faster
        }
        return Math.min(candyType.length / 2, set.size());
    }
}
