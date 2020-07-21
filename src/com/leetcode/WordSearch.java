package com.leetcode;

/**
 * @author Syed Irfan - 21/07/2020
 */
public class WordSearch {
    class Solution {
        public boolean exist(char[][] board, String word) {
            if (word.length() == 0) return true;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (existHelper(board, word, 0, i, j)) return true;
                    }
                }
            }
            return false;
        }
        
        private boolean existHelper(char[][] board, String word, int index, int i, int j) {
            if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word.charAt(index)) {
                return false;
            }
            if (index == word.length() - 1) return true;
            char c = board[i][j];
            board[i][j] = '*';
            boolean isExist = existHelper(board, word, index + 1, i + 1, j) ||
                    existHelper(board, word, index + 1, i, j + 1) ||
                    existHelper(board, word, index + 1, i - 1, j) ||
                    existHelper(board, word, index + 1, i, j - 1);
            board[i][j] = c;
            return isExist;
        }
    }
}
