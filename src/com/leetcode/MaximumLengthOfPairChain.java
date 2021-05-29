package com.leetcode;

import java.util.Arrays;

public class MaximumLengthOfPairChain {
    // Solved it myself
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 1;
        int[] cur = pairs[0];
        for (int i = 1; i < pairs.length; i++) {
            if (cur[1] < pairs[i][0]) {
                res++;
                cur = pairs[i];
            }
        }
        return res;
    }
}
