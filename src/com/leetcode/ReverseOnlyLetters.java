/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class ReverseOnlyLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public static String reverseOnlyLetters(String S) {
		if(S == null | S.trim().length() == 0) {
			return "";
		}
			
		char[] rev = S.toCharArray();
		int left = 0;
		int right = S.length() - 1;
		while (left < right) {
			if (!Character.isLetter(S.charAt(left))) {
				left++;
			} else if (!Character.isLetter(S.charAt(right))) {
				right--;
			} else {
				char leftChar = rev[left];
				rev[left++] = rev[right];
				rev[right--] = leftChar;
				
			}
		}
		return new String(rev);
	}

}
