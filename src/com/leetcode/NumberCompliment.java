package com.leetcode;

public class NumberCompliment {
    public int findComplement(int num) {
        if (num == 0) return 1;
        int i = 0;
        int res = 0;
        while (num > 0) {
            int mul = num % 2 == 1 ? 0 : 1;
            res += mul * Math.pow(2, i++);
            num /= 2;
        }

        return res;
    }
}
