/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class IntegerPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrome(10));

	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0 || x%10 ==0 && x!=0) {
			return false;
		}
		int rev = 0;
		int input = x;
		while(x!=0) {
			int pop = x % 10;
			x = x/10;
			rev = rev * 10 + pop;
		}
		return rev == input;
	}

}
