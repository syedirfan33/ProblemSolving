package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan - 12/07/2020
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, 0, new ArrayList<>(), nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, int idx, List<Integer> cur, int[] nums) {
        res.add(new ArrayList<>(cur));
        for (int i = idx; i < nums.length; i++) {
            cur.add(nums[i]);
            dfs(res, i + 1, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
