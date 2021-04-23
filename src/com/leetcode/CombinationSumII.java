package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    // Proud to say that, I solved it myself. Getting stronger at Backtracking
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> cur) {
        if (target < 0) // I haven't added this piece of code, hence got TLE
            return;
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i == idx || candidates[i] != candidates[i - 1]) {
                cur.add(candidates[i]);
                helper(candidates, target - candidates[i], i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
