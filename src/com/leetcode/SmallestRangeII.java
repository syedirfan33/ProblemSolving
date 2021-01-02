package com.leetcode;

import java.util.Arrays;

public class SmallestRangeII {
    public int smallestRangeII(int[] A, int K) {
        int len = A.length;
        if (len == 1) return 0;
        Arrays.sort(A);
        int res = A[len - 1] - A[0]; // in worst case if we add or sub K from all the elements
        for (int i = 0; i < len - 1; i++) {
            //Always consider A[i] could be the max value
            int min = Math.min(A[0] + K, A[i + 1] - K); // see ex [1,3,6], K = 3
            int max = Math.max(A[i] + K, A[len - 1] - K);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
