package com.leetcode;

import java.util.Arrays;

public class LongestStringChain {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] dp = new int[words.length];
        dp[0] = 1;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (words[i].length() - words[j].length() == 1 && isValid(words[i], words[j])) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.max(dp[i], res);
        }

        return res;
    }

    private boolean isValid(String s1, String s2) {
        boolean isFound = false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (isFound) return false;
                isFound = true;
                i++;
            }
        }

        return true;

    }
}
