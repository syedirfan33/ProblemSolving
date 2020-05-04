/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class RomanToInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(romanToInt("IV"));
	}
	
	public static int romanToInt(String s) {
		int res = 0;
		int cur = 0;
		int prev = 0;
		for(int i=0;i<s.length();i++) {
		    cur = getCharToInt(s.charAt(i));
			if(prev < cur) {
				res -= prev;
				res += cur - prev;
			}else {
				res += cur;;
			}
			prev = cur;
		}
		return res;
	}
	
	private static int getCharToInt(Character c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
		return 1000;
		
		default:
			break;
		}
		return 0;
	}

}
