package com.leetcode;

public class CountBinarySubStrings {
    // Proud that I was able to solve this myself, after thinking for a while
    public int countBinarySubstrings(String s) {
        int res = 0;
        int i = 0;
        int prevCount = 0;
        while (i < s.length()) {
            int right = i;
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            int curCount = right - i + 1;
            res += Math.min(prevCount, curCount);
            prevCount = curCount;
            i = right + 1;
        }
        return res;
    }
}
