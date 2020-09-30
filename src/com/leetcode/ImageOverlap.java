package com.leetcode;

public class ImageOverlap {
    class Solution {
        public int largestOverlap(int[][] A, int[][] B) {
            return Math.max(helper(A, B), helper(B, A));
        }

        private int helper(int[][] A, int[][] B) {
            int n = A.length;
            int res = 0;
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int temp = 0;
                    for (int i = y; i < n; i++) {
                        for (int j = x; j < n; j++) {
                            if (A[i][j] == 1 && B[i - y][j - x] == 1) temp++;
                        }
                    }
                    res = Math.max(res, temp);
                }
            }
            return res;
        }
    }
}
