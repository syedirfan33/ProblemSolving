package com.leetcode;

public class InterleavingStrings {
    // Solved it myself, first I used map as memo, later using solution, I used int[][] for memo. memo size is 1 more to prevent AIBE
    int[][] memo;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new int[s1.length() + 1][s2.length() + 1];
        return helper(0, 0, 0, s1, s2, s3);
    }

    private boolean helper(int i, int j, int k, String s1, String s2, String s3) {
        if (memo[i][j] != 0)
            return memo[i][j] == -1 ? false : true;
        if (k >= s3.length())
            return true;
        char c = s3.charAt(k);
        boolean res = false;
        if (i < s1.length() && s1.charAt(i) == c && j < s2.length() && s2.charAt(j) == c) {
            res = helper(i + 1, j, k + 1, s1, s2, s3) || helper(i, j + 1, k + 1, s1, s2, s3);
        } else if (i < s1.length() && s1.charAt(i) == c) {
            res = helper(i + 1, j, k + 1, s1, s2, s3);
        } else if (j < s2.length() && s2.charAt(j) == c) {
            res = helper(i, j + 1, k + 1, s1, s2, s3);
        }
        memo[i][j] = res ? 1 : -1;
        return res;
    }
}
