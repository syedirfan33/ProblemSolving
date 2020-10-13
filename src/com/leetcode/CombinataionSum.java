package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinataionSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates, int target, int idx, List<Integer> cur) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(res, candidates, target - candidates[i], i, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinataionSum sum = new CombinataionSum();
        sum.combinationSum(new int[]{2,3,5}, 8);
        System.out.println();
    }
}
