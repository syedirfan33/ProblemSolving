package com.leetcode;

public class FindPeakElement {

// As per problem statement nums[-1] = nums[nums.length] == -Infinity
// -∞ | 0,1,2,3|-∞
// -∞ | 3,2,1,0|-∞
// So all one need to do is find the end of any increasing slope in the input array
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int leftEle = mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightEle = mid + 1 >= nums.length ? Integer.MIN_VALUE : nums[mid + 1];
            if (nums[mid] > leftEle && nums[mid] > rightEle) {
                return mid;
            } else if (nums[mid] > rightEle) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
