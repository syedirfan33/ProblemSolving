package com.leetcode;

/**
 * @author Syed Irfan - 21/05/2020
 */
public class CountSquares {
    public static void main(String[] args) {
        CountSquares countSquares = new CountSquares();
        int i = countSquares.countSquaresInMatrix(null);
        System.out.println("i = " + i);
    }
    public int countSquaresInMatrix(int[][] matrix) {
        int res = 0;
        if ((matrix == null || matrix.length == 0)) {
            return res;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                if (matrix[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) +1;
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
