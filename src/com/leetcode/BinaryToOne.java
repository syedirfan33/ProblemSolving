/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class BinaryToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s; 
        s = "101110"; 
 
        System.out.println(calculate_(s)); 
	}
	
	 static int calculate_(String s) 
	    { 
	     // if the size of binary is 1 
	     // then the number of actions will be zero 
	     if (s.length() == 1) 
	         return 0; 
	  
	     // initializing the number of actions as 0 at first 
	     int count_ = 0; 
	     char[] s1=s.toCharArray(); 
	     for (int i = s.length() - 1; i > 0;){ 
	         // start traversing from the last digit 
	         // if its 0 increment the count and decrement i 
	         if (s1[i] == '0') { 
	             count_++; 
	             i--; 
	         } 
	         // if s[i] == '1' 
	         else { 
	             count_++; 
	  
	             // stop until you get 0 in the binary 
	             while (s1[i] == '1' && i > 0) { 
	                 count_++; 
	                 i--; 
	             } 
	             if (i == 0) 
	                 count_++; 
	  
	             // when encounter a 0 replace it with 1 
	             s1[i] = '1'; 
	         } 
	     } 
	     return count_; 
	    }

}
