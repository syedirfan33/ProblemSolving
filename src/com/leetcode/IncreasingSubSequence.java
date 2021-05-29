package com.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubSequence {
    // I solved it myslef, but I used list instead of set and was getting duplicate values(commnet section helped me). One potential improvement is to maintain local set rather than global set. See solution in commnet section
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }

    private void helper(int[] nums, int idx, List<Integer> cur) {
        if (cur.size() > 1) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = idx; i < nums.length; i++) {
            if (idx == 0 || nums[i] >= nums[idx - 1]) {  // or can do nums[i] >= cur.get(cur.size() - 1);
                cur.add(nums[i]);
                helper(nums, i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
