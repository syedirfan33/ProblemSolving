package com.leetcode;

public class JumpGameII {
    public int jump(int[] nums) {
        int res = 0, prevJump = 0, maxJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
            if (prevJump == i) {
                res++;
                prevJump = maxJump;
            }
        }
        return res;
    }
}
