package com.leetcode;

import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        int[] current = new int[]{-1, -1};
        int res = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (interval[0] > current[0] && interval[1] > current[1]) {
                current = interval;
                res++;
            } else {
                current[1] = Math.max(interval[1], current[1]);
            }
        }
        return res;
    }
}
