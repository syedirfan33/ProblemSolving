package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) { // To prevent AIOBE
                int j = stack.pop();
                res[j] = nums[i % nums.length];
            }
            if (i < nums.length) {
                stack.push(i);
            }

        }
        return res;
    }
}
