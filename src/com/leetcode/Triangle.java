package com.leetcode;

import java.util.List;

public class Triangle {
    //Solved by myself
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int min = Integer.MAX_VALUE;
            List<Integer> cur = triangle.get(i);
            List<Integer> prev = triangle.get(i - 1);
            for (int j = 0; j < cur.size(); j++) {
                if (j == 0) {
                    cur.set(j, cur.get(j) + prev.get(j));
                } else if (j == cur.size() - 1) {
                    cur.set(j, cur.get(j) + prev.get(j - 1));
                } else {
                    int curMin = Math.min(prev.get(j), prev.get(j - 1));
                    cur.set(j, curMin + cur.get(j));
                }
                min = Math.min(min, cur.get(j));
            }

            res = min;
        }
        return res;
    }
}
