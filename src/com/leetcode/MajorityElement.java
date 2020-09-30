package com.leetcode;

public class MajorityElement {
    //Moore's algorithm / Voting algorithm
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int num : nums) {
            if (res == num) {
                cnt++;
            } else {
                cnt--;
            }

            if (cnt == 0) {
                cnt = 1;
                res = num;
            }
        }
        return res;
    }
}
