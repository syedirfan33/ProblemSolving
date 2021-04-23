package com.leetcode;

public class LongestPalindromicSubString {
    int maxLen = 1;
    int startPos = 0;

    public String longestPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            getLongestPalindrome(str, i, i); // for odd length - a b c
            getLongestPalindrome(str, i, i + 1); // for even length - b a a b
        }
        return str.substring(startPos, startPos + maxLen);
    }


    private void getLongestPalindrome(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        if (right - left - 1 > maxLen) {
            maxLen = right - left - 1;
            startPos = left + 1;
        }
    }
}
