package com.algoexpert;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ApartmentHunting {
    // This is DP problem where you have to traverse twice, left to right and right to left to fill dp array, It's actually easyto come up with solution but little trickly to write solution
    // My solution is way better than official solution
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] res = new int[blocks.size()][reqs.length];
        for (int i = 0; i < blocks.size(); i++) {
            Map<String, Boolean> cur = blocks.get(i);
            for (int j = 0; j < reqs.length; j++) {
                int distance = cur.get(reqs[j]) == true ? 0 : Integer.MAX_VALUE;
                if (i != 0 && distance != 0) {
                    int prev = res[i - 1][j] != Integer.MAX_VALUE ? res[i - 1][j] + 1 : Integer.MAX_VALUE;
                    distance = Math.min(distance, prev);
                }
                res[i][j] = distance;
            }
        }
        System.out.println(Arrays.deepToString(res));
        int out = Integer.MAX_VALUE;
        int outIdx = 0;
        for (int i = blocks.size() - 1; i >= 0; i--) {
            int curOut = Integer.MIN_VALUE;
            for (int j = 0; j < reqs.length; j++) {
                if (i != blocks.size() - 1 && res[i][j] != 0) {
                    int prev = res[i + 1][j] != Integer.MAX_VALUE ? res[i + 1][j] + 1 : Integer.MAX_VALUE;
                    res[i][j] = Math.min(res[i][j], prev);
                }
                curOut = Math.max(curOut, res[i][j]);
            }
            if (curOut < out) {
                out = curOut;
                outIdx = i;
            }
        }
        System.out.println(Arrays.deepToString(res));
        return outIdx;
    }
}
