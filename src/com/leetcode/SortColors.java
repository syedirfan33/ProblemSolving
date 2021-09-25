package com.leetcode;

/**
 * @author Syed Irfan - 13/06/2020
 */
public class SortColors {
    // Video from Codebix
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (mid <= right) {
            int cur = nums[mid];
            if (cur == 2) {
                swap(mid, right, nums);
                right--;
            } else if (cur == 0) {
                swap(mid, left, nums);
                left++;
                mid++;
            } else {
                mid++;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

