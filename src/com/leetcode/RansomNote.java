/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class RansomNote {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean canConstruct(String ransomNote, String magazine) {
	        int[] arr=new int[26];
	        for(char c: magazine.toCharArray()){
	            arr[c - 'a']++;
	        }
	        
	        for(char c: ransomNote.toCharArray()){
	            if(arr[c - 'a'] == 0) return false;
	            else arr[c - 'a']--;
	        }
	        return true;
	    }

}
