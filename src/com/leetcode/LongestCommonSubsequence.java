/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Very similar to min edit distance, delete operations of 2 strings

	public int longestCommonSubsequence(String text1, String text2) {
	        int rows = text1.length();
	        int columns = text2.length();
	        int[][] dp = new int[rows+1][columns+1];
	        for(int i=1;i<=rows;i++){
	            for(int j=1;j<=columns;j++){
	                if(text1.charAt(i-1) == text2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
	                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        }
	        System.out.println(Arrays.deepToString(dp));
	        return dp[rows][columns];
	    }

}
