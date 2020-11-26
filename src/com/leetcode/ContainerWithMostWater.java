package com.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area);
            if (height[left] > height[right]) right--;
            else left++;
        }
        return res;
    }
}
