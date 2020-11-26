package com.leetcode;

public class ConvertIntegerIntoSunOfNonZero {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (!containZero(a) && !containZero(b))
                return new int[]{a, b};
        }
        return new int[]{}; // unreachable because at least one valid solution
    }

    private boolean containZero(int n) {
        while (n != 0) {
            if (n % 10 == 0) return true;
            n /= 10;
        }
        return false;
    }
}
