package com.leetcode;

public class RemoveDuplicatesFromSortedArrayII {
    //Same as remove I with minor change
    public int removeDuplicates(int[] nums) {
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}

