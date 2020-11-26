/**
 *
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Syed Irfan
 *
 */
public class MergeIntervals {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] inp = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] inp2 = {{1, 5}, {3, 6}, {2, 8}};

        System.out.println(Arrays.deepToString(merge(inp2)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] < intervals[i][0]) {
                res.add(current);
                current = intervals[i];
            } else {
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        res.add(current);
        return res.toArray(new int[res.size()][]);
    }

}
