package com.leetcode;

public class WiggleSequence {

    //First I solved it using stack, yes myself. Then I realized that stack always contains only 1 element, hence no need to use stack. Just prev variable is enough
    //See a DP based solution, top voted in discuss. Quite high IQ solution
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        Boolean increase = null;
        int prev = nums[0];
        int res = 1;
        for (int num : nums) {
            if (increase != null && increase) {
                if (prev < num) {
                    increase = false;
                    prev = num;
                    res++;
                } else {
                    prev = Math.min(prev, num);
                }
            } else if (increase != null && !increase) {
                if (prev > num) {
                    increase = true;
                    prev = num;
                    res++;
                } else {
                    prev = Math.max(prev, num);
                }
            } else if (increase == null && prev != num) {
                increase = prev < num ? false : true;
                prev = num;
                res++;
            }
        }
        return res;
    }
}
