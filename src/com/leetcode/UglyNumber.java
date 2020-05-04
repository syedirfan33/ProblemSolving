/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Syed Irfan
 *
 */
public class UglyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(8));
	}

	public static boolean isUgly(int num) {
		if(num<1) return false;
		int[] divisors = {2,3,5};
		for(int d:divisors) {
			while(num%d == 0) {
				num/=d;
			}
		}
		return num == 1;
	}

}
