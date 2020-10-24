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

    //same solution as MinimumArrowToBurstBallons
 /*   public class Solution {
        public int eraseOverlapIntervals(Interval[] intervals) {
            if (intervals.length == 0 ) return 0;
            Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1.end, i2.end));

            int end = intervals[0].end;
            int count = 0;
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i].start >= end) end = intervals[i].end;
                else count++;
            }
            return count;
        }
    }*/
}


