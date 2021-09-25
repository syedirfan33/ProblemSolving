package com.leetcode;

public class ArrayNesting {
    //Video from coding decoded
    public int arrayNesting(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            int j = i;
            while (nums[j] != Integer.MAX_VALUE) {
                int temp = nums[j];
                nums[j] = Integer.MAX_VALUE;
                j = temp;
                cur++;
            }
            res = Math.max(cur, res);
        }
        return res;
    }
}
