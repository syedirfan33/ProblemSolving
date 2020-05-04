/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class BinarySearchII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        boolean fuz = false;
        while(nums[left] > nums[right]){
           right--;
           
        }
        if(target == nums[right]) return right;
        else if(target < nums[left]){
            left = right + 1;
            right = nums.length - 1;
        }
        while(left <= right){    
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {return mid;}
            else if(nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

}
