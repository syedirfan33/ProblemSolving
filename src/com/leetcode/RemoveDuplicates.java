/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class RemoveDuplicates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[] {1,1,2,3,4}));
	}
	
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for(int j=1;j<nums.length;j++) {
			if(nums[j]!=nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

}
