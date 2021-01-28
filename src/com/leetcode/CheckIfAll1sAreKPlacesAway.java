package com.leetcode;

public class CheckIfAll1sAreKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        int dis = k; // it handles  corner case [0,1,0,0,1,0,0,1,0] 2 out should be true
        for (int num : nums) {
            if (num == 1) {
                if (dis < k) return false;
                dis = 0;
            } else {
                dis++;
            }
        }
        return true;
    }
}
