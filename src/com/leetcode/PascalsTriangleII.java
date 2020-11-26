package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) return res;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            List<Integer> prev = res.get(res.size() - 1);
            for (int j = 1; j < i; j++) {
                cur.add(prev.get(j - 1) + prev.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
