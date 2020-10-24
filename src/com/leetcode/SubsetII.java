package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        helper(A, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res, List<Integer> cur, int idx) {
        res.add(new ArrayList<>(cur));
        for (int i = idx; i < A.size(); i++) {
            if (i == idx || A.get(i) != A.get(i - 1)) {
                cur.add(A.get(i));
                helper(A, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
