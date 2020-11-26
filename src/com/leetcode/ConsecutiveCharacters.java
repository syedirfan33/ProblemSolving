package com.leetcode;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        int n = s.length();
        if (n <= 1) return n;
        int res = Integer.MIN_VALUE;
        int first = 0, second = 1;
        while (second < n) {
            while (second < n && s.charAt(first) == s.charAt(second))
                second++;
            res = Math.max(res, second - first);
            first = second;
            second = first + 1;
        }
        return res;
    }
}
