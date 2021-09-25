package com.leetcode;

public class GameOfLife {
    // Video from Naresh.
    public void gameOfLife(int[][] board) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = 0;
                for (int[] dir : dirs) {
                    int nextI = i + dir[0];
                    int nextJ = j + dir[1];
                    if (isValid(nextI, nextJ, board) && Math.abs(board[nextI][nextJ]) == 1) {
                        liveCount++;
                    }
                }
                if (board[i][j] == 0 && liveCount == 3) {
                    board[i][j] = 2;
                } else if (board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }

    private boolean isValid(int i, int j, int[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
