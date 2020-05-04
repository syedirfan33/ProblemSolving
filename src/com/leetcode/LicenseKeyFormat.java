/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class LicenseKeyFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(licenseKeyFormatting("-a-a-a-a--", 2));
	}
	
	 public static String licenseKeyFormatting(String S, int K) {
	        StringBuilder res = new StringBuilder();
	        int count = K;
	        int i = S.length()-1;
	        while(i>=0) {
	        	char cur = Character.toUpperCase(S.charAt(i));
	        	if(S.charAt(i) != '-') {
	        		
	        		res.append(cur);
	        		count--;
	        	}
	        	if(count == 0 && i!=0 && S.charAt(i-1) !='-' ) {
	        		System.out.println(i);
	        		res.append('-');
	        		count = K;
	        	}
	        	i--;
	        }
	        return res.reverse().toString();
	    }

}
