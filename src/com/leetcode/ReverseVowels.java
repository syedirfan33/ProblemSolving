/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class ReverseVowels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("leetcode"));
		String s = "abbdef";
		System.out.println(s.replace(s.charAt(1), s.charAt(5)));
	}

	public static String reverseVowels(String s) {
		int left = 0;
		int right = s.length()-1;
		char[] output = s.toCharArray();
		while(left < right) {
			while(!isVowel(s.charAt(left)) && left < right) {
				left++;
			}
			while(!isVowel(s.charAt(right)) && left < right) {
				right--;
			}
			char rightChar = output[right];
			output[right] = output[left];
			output[left] = rightChar;

			left++;
			right--;
		}
		return new String(output);
	}
	
	private static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}
