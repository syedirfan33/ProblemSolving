package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (right < nums.length - 1 && nums[right + 1] - nums[right] == 1) {
                right++;
            } else {
                StringBuilder cur = new StringBuilder();
                if (left == right) {
                    cur.append(nums[left]);
                    left++;
                    right++;
                } else {
                    cur.append(nums[left]).append("->").append(nums[right]);
                    left = right + 1;
                    right = left;
                }
                res.add(cur.toString());
            }
        }
        return res;
    }
}
