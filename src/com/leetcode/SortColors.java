package com.leetcode;

/**
 * @author Syed Irfan - 13/06/2020
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (mid <= right) {
            int curColor = nums[mid];
            if (curColor == 2) {
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            } else if (curColor == 0) {
                nums[mid] = nums[left];
                nums[left] = 0;
                mid++;
                left++;
            } else {
                mid++; // Just move mid pointer if color is 1
            }
        }
    }
}
