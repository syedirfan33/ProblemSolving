/**
 * 
 */
package com.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Syed Irfan
 *
 */
public class FirstUnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(firstUniqChar("irfanifan"));
	}

	 public static int firstUniqChar(String s) {
	   Map<Character, Integer> charmap = new LinkedHashMap<>();
	   for(int i=0;i<s.length();i++) {
		   Character current = s.charAt(i);
		   if(charmap.containsKey(current)) {
			   charmap.put(current, -1);
		   }else {
			   charmap.put(current, i);
		   }
	   }
	   for(Character c : charmap.keySet()) {
		   if(charmap.get(c) > -1) return charmap.get(c);
	   }
	   
	   
	   return -1;
	 }
}
