package com.leetcode;

public class GlobalAndLocaInversions {
    // VIDEO FROM Nick
    public boolean isIdealPermutation(int[] A) {
        int max = 0;
        for (int i = 0; i + 2 < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2])
                return false;
        }
        return true;
    }
}
