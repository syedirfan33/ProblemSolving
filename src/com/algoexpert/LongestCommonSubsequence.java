package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return buildRes(dp, str1, str2);
    }

    private static List<Character> buildRes(int[][] dp, String str1, String str2) {
        List<Character> res = new ArrayList<>();
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i != 0 && j != 0) {
            // This means we have came from left, do go to left
            if (dp[i][j] == dp[i][j - 1]) {
                j--;
                // THis means that we have came from top, go to top
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
                // Else we have came from diagonal, including current char
            } else {
                res.add(0, str1.charAt(i - 1));
                i--;
                j--;
            }
        }
        return res;
    }
}
