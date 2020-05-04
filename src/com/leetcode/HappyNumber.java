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
public class HappyNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
	}
	
	 public static boolean isHappy(int n) {
	        Set<Integer> seen = new HashSet<>();
	        
	        while(n!=1){
	            int current = n;
	            int sum = 0;
	            while(current!=0){
	                sum += (current%10) * (current%10); 
	                current /= 10;
	               
	            }
	            
	            if(seen.contains(sum)) return false;
	            seen.add(sum);
	            n = sum;
	        }
	        
	        return true;
	    }

}
