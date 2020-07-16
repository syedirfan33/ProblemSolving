package com.leetcode;

/**
 * @author Syed Irfan - 21/06/2020
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int left = 0;
        while (left < nums.length) {
            if (nums[left] == 0) {
                int right = left + 1;
                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right >= nums.length) break;
                nums[left] = nums[right];
                nums[right] = 0;
                
            }
            left++;
        }
    }
}
