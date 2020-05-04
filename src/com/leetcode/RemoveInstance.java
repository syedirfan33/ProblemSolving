/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class RemoveInstance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeInstance(new int[] {1,2,3,2}, 2));

	}

	public static int removeInstance(int[] nums, int val) {
		 int i = 0;
	       for(int j=0;j<nums.length;j++){
	           if(nums[j]!=val){   
	               System.out.println(j);
	               nums[i] = nums[j];
	                i++;
	           }
	       }
	        return i;
	}
}
