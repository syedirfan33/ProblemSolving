/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean canJump(int[] nums) {
        int lastIdxPosi = nums.length-1;
        for(int i = nums.length-1;i>=0;i--){
            if(i+nums[i] >= lastIdxPosi) lastIdxPosi = i;
        }
        return lastIdxPosi == 0;
    }

}
