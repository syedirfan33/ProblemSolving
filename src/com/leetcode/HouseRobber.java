package com.leetcode;

/**
 * @author Syed Irfan - 01/06/2020
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n_1 = 0; // n - 1
        int n_2 = 0; // n - 2
        for (int num : nums) {
            int res = Math.max(num + n_2, n_1);
            n_2 = n_1;
            n_1 = res;
        }
        return n_1;
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]); // consider [2,1,1,2]
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }

        return nums[nums.length - 1];
    }
}
