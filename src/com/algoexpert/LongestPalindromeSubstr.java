/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class LongestPalindromeSubstr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubstring("aaaaba"));

	}

	// Refer to leetcode's solution for better understanding
	public static String longestPalindromeSubstring(String str) {
		int[] current = {0,1};
		for(int i=0;i<str.length();i++) {
			int[] odd = getLongestPalindrome(str, i-1, i+1);
			int[] even = getLongestPalindrome(str, i-1, i);
			int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even ;
			current = longest[1] - longest[0] > current[1] - current[0] ? longest : current;
		}
		return str.substring(current[0], current[1]);
	}

	private static int[] getLongestPalindrome(String str, int left, int right) {
		while(left>=0 && right<str.length()) {
			if(str.charAt(left) != str.charAt(right)) {
				break;
			}
			left--;
			right++;
		}
		return new int[]{left+1, right};
	}

}
