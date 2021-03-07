package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // My solution, this can be LITTLE optimised( optional )
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(new ArrayList<>(), k, 1, n);
        return res;
    }

    private void dfs(List<Integer> cur, int k, int start, int end) {
        if (k == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i <= end; i++) {   // Optimization,  i <= end - k + 1
            cur.add(i);
            dfs(cur, k - 1, i + 1, end);
            cur.remove(cur.size() - 1);
        }
    }
}
