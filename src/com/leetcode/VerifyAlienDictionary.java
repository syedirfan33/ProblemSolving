/**
 * 
 */
package com.leetcode;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class VerifyAlienDictionary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
	}

	public static boolean isAlienSorted(String[] words, String order) {
		int[] alphabets = new int[26];
		for(int i=0;i<order.length();i++) {
			alphabets[order.charAt(i) - 'a'] = i;
		}
		
		for(int j=0;j<words.length -1; j++) {
			for(int l=j+1;l<words.length;l++) {
			String current = words[j];
			String next = words[l];
			int min = Math.min(current.length(), next.length());
			for(int k = 0;k<current.length();k++) {
				if(alphabets[current.charAt(k) - 'a'] > alphabets[next.charAt(k) - 'a']) return false;
				else if(alphabets[current.charAt(k) - 'a'] < alphabets[next.charAt(k) - 'a']) break;
				else if(k == min - 1 && current.length() > next.length()) return false;
			}
			}
		}
		
		return true;
	}

}
