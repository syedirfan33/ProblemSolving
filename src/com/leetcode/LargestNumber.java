package com.leetcode;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = nums[i] + "";
        }

        Arrays.sort(numsStr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        if (numsStr[0].charAt(0) == '0') return "0";
        StringBuilder res = new StringBuilder();
        for (String str : numsStr) {
            res.append(str);
        }

        return res.toString();
    }
}
