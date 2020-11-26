package com.leetcode;

public class SearchInARotatedSortedArray {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425/Concise-O(log-N)-Binary-search-solution - See comment #1.
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (nums.length == 0) return -1;
        int minIdx = getMinIdx(nums);
        if (nums[minIdx] == target) return minIdx;
        if (nums[len - 1] == target) return len - 1;
        int start = target > nums[len - 1] ? 0 : minIdx;
        int end = target > nums[len - 1] ? minIdx - 1 : len - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) start = mid + 1;
            else end = mid - 1;
        }

        return -1;


    }

    private int getMinIdx(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid; // Visualize different scenarios lah, don't behave like a stupid
            }
        }
        return start;
    }
}
