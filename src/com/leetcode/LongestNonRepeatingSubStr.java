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
public class LongestNonRepeatingSubStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int lengthOfLongestSubstring(String S) {
	        if(S == null) return 0;
	        int i = 0;
	        int j = 0;
	        int max = 0;
	        
	        Set<Character> set = new HashSet<>();
	        
	        while(j < S.length()){
	            char cur = S.charAt(j);
	            if(!set.contains(cur)){
	                set.add(cur);
	                j++;
	                max = Math.max(max, j - i);  // or  max = Math.max(max, set.size()); b a c a
	            }else{
	                set.remove(S.charAt(i));  
	                i++;
	            }
	        }
	        return max;
	    }

}
