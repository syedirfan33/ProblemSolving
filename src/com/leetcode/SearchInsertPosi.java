/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class SearchInsertPosi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(searchInsert(new int[] {1, 3,5,6},7));
	}
	
	public static int searchInsert(int[] nums, int target) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}

}
