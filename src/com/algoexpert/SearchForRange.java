package com.algoexpert;

public class SearchForRange {
    // Same as 34. Find First and Last Position of Element in Sorted Array leetcode;
    public static int[] searchForRange(int[] array, int target) {
        int left = binarySearch(0, array.length - 1, array, target, true);
        if (left == -1) return new int[]{-1, -1};
        int right = binarySearch(left, array.length - 1, array, target, false);
        return new int[]{left, right};
    }

    private static int binarySearch(int left, int right, int[] array, int target, boolean isLow) {
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                index = mid;
                if (isLow) right = mid - 1;
                else left = mid + 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
