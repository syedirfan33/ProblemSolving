/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class ClimbStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(3));

	}
	
	public static int climbStairs(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		int first = 1;
		int second = 2;
		int total = 0;
		int idx = 3;
		while(idx!=n+1) {
			total = second + first;
			first = second;
			second = total;
			idx++;
		}
		return total;
	}

}
