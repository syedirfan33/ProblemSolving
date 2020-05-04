/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class ProductOfArrayExceptSelf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//see the leetcode solution to understand how to solve in O(1) space, it's very easy lahhhhh

	 public int[] productExceptSelf(int[] nums) {
	        int n = nums.length;
	        int[] left = new int[n];
	        left[0] = 1;
	        for(int i=1;i<n;i++){
	            left[i] = left[i - 1] * nums[i - 1];
	        }
	        int[] right = new int[n];
	        right[n-1] = 1;
	        for(int j=n-2;j>=0;j--){
	            right[j] = nums[j+1] * right[j+1];
	        }
	        
	        int[] res = new int[n];
	       
	        for(int i=0;i<n;i++){
	            res[i] = left[i] * right[i];
	        }

	        return res;
	    }
	 
}
