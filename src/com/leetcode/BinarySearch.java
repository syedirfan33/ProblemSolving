/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int midpoint = left + (right - left) /2;
            if(target == nums[midpoint]) {index = midpoint;break;}
            else if(target < nums[midpoint]) right = midpoint - 1;
            else left = midpoint + 1;
        }
        return index;
    }

}
