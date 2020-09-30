package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int cur = Math.abs(num);
            if (nums[cur - 1] < 0) res.add(cur);
            else nums[cur - 1] = -nums[cur - 1];
        }
        return res;
    }
}
