package com.leetcode;

import java.util.ArrayList;
import java.util.List;


//Inspired by merge interval
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArray = new int[intervals.length + 1][2];
        if (intervals.length == 0) {
            newArray[0] = newInterval;
            return newArray;
        }
        int j = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval != null && intervals[i][0] > newInterval[0]) {
                newArray[j++] = newInterval;
                newInterval = null;
                i--;
            } else {
                newArray[j++] = intervals[i];
            }
        }
        if (newInterval != null) newArray[j] = newInterval;
        List<int[]> res = new ArrayList<>();
        int[] cur = newArray[0];
        res.add(cur);
        for (int i = 1; i < newArray.length; i++) {
            int cur_end = cur[1];
            int next_start = newArray[i][0];
            int next_end = newArray[i][1];
            if (cur_end < next_start) {
                cur = newArray[i];
                res.add(cur);
            } else {
                cur[1] = Math.max(cur_end, next_end);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
