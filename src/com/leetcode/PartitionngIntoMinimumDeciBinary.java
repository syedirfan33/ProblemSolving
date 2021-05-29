package com.leetcode;

public class PartitionngIntoMinimumDeciBinary {
    // Video from knowledge center
    public int minPartitions(String n) {
        int res = 0;
        for (char c : n.toCharArray()) {
            res = Math.max(res, c - '0');
        }
        return res;
    }
}
