/**
 * 
 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {3, 2, 4};
		
		System.out.println(Arrays.toString(twoSum(input, 6)));

	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			int potentialMatch = target - nums[i];
			if(map.containsKey(potentialMatch)) {
				return new int[] {map.get(potentialMatch),i};
			}
			map.put(nums[i], i);
		}
		return new int[] {0,0};
	}
}
