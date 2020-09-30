package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinataionSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, int idx, int k, int target) {
        if (cur.size() == k && target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i <= 9; i++) {
            cur.add(i);
            helper(res, cur, i + 1, k, target - i);
            cur.remove(cur.size() - 1);
        }
    }
}
