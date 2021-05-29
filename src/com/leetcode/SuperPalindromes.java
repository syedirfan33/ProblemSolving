package com.leetcode;

public class SuperPalindromes {
    // Official solution and video from algorithms made easy
    public int superpalindromesInRange(String left, String right) {
        int res = 0;
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        for (int i = 0; i < 100000; i++) {
            StringBuilder cur = new StringBuilder(String.valueOf(i));
            for (int j = cur.length() - 1; j >= 0; j--)
                cur.append(cur.charAt(j));
            Long curVal = Long.parseLong(cur.toString());
            curVal *= curVal;
            if (curVal > r)
                break;
            else if (curVal >= l && isPalindrome(curVal.toString()))
                res++;
        }
        for (int i = 0; i < 100000; i++) {
            StringBuilder cur = new StringBuilder(String.valueOf(i));
            for (int j = cur.length() - 2; j >= 0; j--)
                cur.append(cur.charAt(j));
            Long curVal = Long.parseLong(cur.toString());
            curVal *= curVal;
            if (curVal > r)
                break;
            else if (curVal >= l && isPalindrome(curVal.toString()))
                res++;
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        }
        return true;
    }
}
