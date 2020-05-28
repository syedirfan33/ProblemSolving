package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class ContiguosSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));

	}

	
	public static int maxSubArray(int[] nums) {
		int curMax = nums[0];
		for(int i=1;i<nums.length;i++) {
			int curSum = nums[i] + nums[i-1];
			System.out.println(curSum);
			nums[i] = Math.max(curSum, nums[i]);
			curMax = Math.max(nums[i], curMax);
		}
		System.out.println(Arrays.toString(nums));
		return curMax;
	}
}
