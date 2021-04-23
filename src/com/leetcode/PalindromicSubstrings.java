package com.leetcode;

public class PalindromicSubstrings {
    // Same as Longest palindromic substring
    int res = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expand(i, i, s);
            expand(i, i + 1, s);
        }
        return res;
    }

    private void expand(int left, int right, String s) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right))
                break;
            res++;
            left--;
            right++;
        }
    }
}
