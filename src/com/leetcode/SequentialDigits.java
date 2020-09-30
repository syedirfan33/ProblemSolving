package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        String digits = "123456789";
        List<Integer> res = new ArrayList<>();
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int i = lowLen; i <= highLen; i++) {
            for (int j = 0; j < 10 - i; j++) {
                Integer cur = Integer.parseInt(digits.substring(j, j + i));
                if (cur >= low && cur <= high) res.add(cur);
            }
        }
        return res;

    }

}