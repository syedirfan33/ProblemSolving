package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();

        helper(0, nums, new ArrayList<>());
        return res;
    }

    private void helper(int idx, int[] nums, List<Integer> cur) {
        res.add(new ArrayList<>(cur));

        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(i + 1, nums, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
