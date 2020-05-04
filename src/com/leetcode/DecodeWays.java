/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		numDecodings("123");
	}

	public static int numDecodings(String s) {
		if(s == null || s.trim().length() == 0) return 0;
		int n = s.length();
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for(int i=2;i<=n;i++) {
		    int first = Integer.valueOf(s.substring(i-1, i));
			int second = Integer.valueOf(s.substring(i-2, i));
			System.out.println(first);
			System.out.println(second);
			if(first>=1 && first<=9) {
				dp[i] = dp[i-1];	
			}
			if(second>=10 && second<=26) {
				dp[i] += dp[i-2];
			}
			
		}
        		System.out.println(Arrays.toString(dp));

		return dp[n];
	}
}
