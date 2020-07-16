package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan - 12/07/2020
 */
public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums.length == 0) return res;
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> cur = new ArrayList<>(res.get(i));
                cur.add(num);
                res.add(cur);
            }
        }
        return res;
    }
}
