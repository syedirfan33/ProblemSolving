package com.leetcode;

/**
 * @author Syed Irfan - 28/05/2020
 */
// Very similar to min edit distance, longest common subsequence
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();
        int[][] dp = new int[word1Len + 1][word2Len + 1];
        
        for (int i = 1; i <= word1Len; i++) {
            dp[i][0] = i;
        }
        
        for (int i = 1; i <= word2Len; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= word1Len; i++) {
            for (int j = 1; j <= word2Len; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        
        return dp[word1Len][word2Len];
    }

    // Without using extra loop
    public int minDistanceII(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = i + j;
                else{
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = 1 + Math.min(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
