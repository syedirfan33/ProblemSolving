package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    // Having same idea as sudoku solver, watch video from Anuj bhaiyaa. isValid method can be improved
    List<List<String>> res;
    int[][] dirs = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        char[][] resArr = new char[n][n];
        helper(resArr, n, 0);
        return res;
    }

    private void helper(char[][] resArr, int n, int row) {
        if (row == n) {
            buildRes(resArr);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(resArr, row, col, n)) {
                resArr[row][col] = 'Q';
                helper(resArr, n, row + 1);
                resArr[row][col] = ' ';

            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q' || board[row][i] == 'Q')
                return false;
            for (int[] dir : dirs) {
                int nextX = dir[0] * i + row;
                int nextY = dir[1] * i + col;
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (board[nextX][nextY] == 'Q')
                        return false;
                }
            }
        }
        return true;
    }

    private void buildRes(char[][] board) {
        List<String> li = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder cur = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q')
                    cur.append(board[i][j]);
                else
                    cur.append('.');
            }
            li.add(cur.toString());
        }
        res.add(li);
    }
}
