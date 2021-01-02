package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> abMap = new HashMap<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int num = A[i] + B[j];
                abMap.put(num, abMap.getOrDefault(num, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int other = C[i] + D[j];
                res += abMap.getOrDefault(-1 * other, 0);
            }
        }
        return res;
    }
}
