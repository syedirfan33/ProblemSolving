package com.leetcode;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int res = 0;
        int last_included = 0; // The interval which is not removed
        for (int i = 1; i < intervals.length; i++) {
            // Overlapping case
            if (intervals[i][0] < intervals[last_included][1]) {
                res++;
                if (intervals[i][1] < intervals[last_included][1]) {
                    last_included = i;  // Visualise laaa, very easy
                }
            // Non overlapping case
            } else {
                last_included = i;
            }
        }
        return res;
    }
}
