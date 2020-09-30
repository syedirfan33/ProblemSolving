package com.leetcode;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] map = new int[58];
        for (char ch : s.toCharArray()) {
            map[ch - 'A']++;
        }
        boolean hasOdd = false;
        int ans = 0;
        for (int i = 0; i < 58; i++) {
            if (map[i] % 2 == 1) {
                ans += map[i] - 1;
                hasOdd = true;
            } else {
                ans += map[i];
            }
        }
        return hasOdd ? ans + 1 : ans;
    }
}
