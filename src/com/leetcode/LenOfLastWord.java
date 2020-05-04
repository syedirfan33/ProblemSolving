/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class LenOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord(" a "));
	}
	//I came up with a better solution, check submission history
	public static int lengthOfLastWord(String s) {
		int len = 0;
        s = s.trim();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)!=' ') {
				len+=1;
			}else {
				len = 0;
			}
		}
		return len;
	}

}
