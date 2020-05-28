package com.leetcode;

/**
 * @author Syed Irfan - 26/05/2020
 */
public class MinimumASCIIDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
        int res = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1;i<=s2.length();i++){
            dp[0][i] = s2.charAt(i-1) + dp[0][i-1];
        }
        
        for(int i = 1;i<=s1.length();i++){
            dp[i][0] = s1.charAt(i-1) + dp[i-1][0];
        }
        
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(s1.charAt(i - 1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    
                }else{
                    dp[i][j] = Math.min((int) s1.charAt(i-1) + dp[i-1][j], (int) s2.charAt(j-1) + dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
