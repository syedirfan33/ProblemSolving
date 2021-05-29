package com.leetcode;

import java.util.*;

public class SudokuSolver {
    // I solved it myself based on valid sudoku approach and little backtracking help from algo expert
    Set<String> set;

    public void solveSudoku(char[][] board) {
        set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char cur = board[i][j];
                if (cur != '.') {
                    set.add(cur + " row " + i);
                    set.add(cur + " column " + j);
                    set.add(cur + " box " + i / 3 + ":" + j / 3);
                }
            }
        }
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (j >= 9) {
            i += 1;
            j = 0;
            if (i >= 9) {
                return true;
            }
        }
        if (board[i][j] != '.')
            return solve(board, i, j + 1);

        for (char c = '1'; c <= '9'; c++) {
            if (isValid(i, j, c)) {
                add(i, j, c);
                board[i][j] = c;

                if (solve(board, i, j + 1)) {
                    return true;
                } else {
                    board[i][j] = '.';
                    reset(i, j, c);
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, char c) {
        if (set.contains(c + " row " + i) || set.contains(c + " column " + j) || set.contains(c + " box " + i / 3 + ":" + j / 3))
            return false;

        return true;
    }

    private void reset(int i, int j, char c) {
        set.remove(c + " row " + i);
        set.remove(c + " column " + j);
        set.remove(c + " box " + i / 3 + ":" + j / 3);
    }

    private void add(int i, int j, char c) {
        set.add(c + " row " + i);
        set.add(c + " column " + j);
        set.add(c + " box " + i / 3 + ":" + j / 3);
    }
}
