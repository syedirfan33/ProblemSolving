package com.leetcode;

public class IncreasingTripletSubsequence {
    // My solution
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        int prevSecond = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > second || nums[i] > prevSecond) return true;
            if (nums[i] < first) {
                first = nums[i];
                prevSecond = second;
                second = Integer.MAX_VALUE;
            } else if (nums[i] > first && nums[i] < second) {
                second = nums[i];
            }
        }
        return false;
    }

    // Concise java solution
    public boolean increasingTripletII(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { small = n; } // update small if n is smaller than both
            else if (n <= big) { big = n; } // update big only if greater than small but smaller than big
            else return true; // return if you find a number bigger than both
        }
        return false;
    }
}
