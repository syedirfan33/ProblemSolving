/**
 * 
 */
package com.leetcode;

import java.util.Comparator;

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
// My solution
	public int romanToIntII(String s) {
		int res = 0;
		for(int i = 0; i < s.length(); i++){
			char cur = s.charAt(i);
			char next = i == s.length() - 1 ? '0' : s.charAt(i + 1);
			//I can be placed before V (5) and X (10) to make 4 and 9.
			//X can be placed before L (50) and C (100) to make 40 and 90.
			//C can be placed before D (500) and M (1000) to make 400 and 900.
			if((cur == 'I' && (next == 'V' || next == 'X')) || (cur == 'X' && (next == 'L' || next == 'C')) || (cur == 'C' && (next == 'D' || next == 'M'))){
				res -= getVal(cur);
			}else{
				res += getVal(cur);
			}
		}
		return res;
	}

	private int getVal(char c){
		switch(c){
			case 'I': return 1;
			case 'V': return 5;
			case 'X': return 10;
			case 'L': return 50;
			case 'C': return 100;
			case 'D': return 500;
			case 'M': return 1000;
			default: return 0;
		}
	}

}
