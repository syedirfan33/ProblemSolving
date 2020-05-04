/**
 * 
 */
package com.leetcode;

import java.security.DigestInputStream;
import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9, 9 })));
	}

	public static int[] plusOne(int[] digits) {
		int i = digits.length - 1;
		while (i >= 0) {
			if (digits[i] == 9) {
				digits[i] = 0;
				i--;
			} else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}
		int[] newArr = new int[digits.length + 1];
		newArr[0] = 1;
		return newArr;
	}

}
