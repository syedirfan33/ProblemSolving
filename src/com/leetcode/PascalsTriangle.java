package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            res.add(1);
        }
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                res.set(j, res.get(j) + res.get(j - 1));
            }
        }
        return res;
    }
}
