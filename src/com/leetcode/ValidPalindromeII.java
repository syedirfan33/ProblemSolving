package com.leetcode;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s.length() == 0) return false;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (helper(left + 1, right, s)) return true;
                else if (helper(left, right - 1, s)) return true;
                else return false;
            } else {
                left++;
                right--;
            }

        }
        return true;
    }

    private boolean helper(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
