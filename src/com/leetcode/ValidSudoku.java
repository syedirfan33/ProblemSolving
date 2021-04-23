package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Video from nick white
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    if (!set.add(cur + "row" + i) || !set.add(cur + "column" + j) || !set.add(cur + "box" + i / 3 + ":" + j / 3))
                        return false;
                }
            }
        }
        return true;
    }
}
