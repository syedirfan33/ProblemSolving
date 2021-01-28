package com.algoexpert;



public class RemoveIsland {
    public int[][] removeIslands(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) return matrix;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) dfs(0, i, matrix);
        }
        for (int i = 0; i < n; i++) {
            if (matrix[m - 1][i] == 1) dfs(m - 1, i, matrix);
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) dfs(i, 0, matrix);
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == 1) dfs(i, n - 1, matrix);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 2) matrix[i][j] = 1;
                else if (matrix[i][j] == 1) matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private void dfs(int i, int j, int[][] matrix) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0 || matrix[i][j] == 2)
            return;
        matrix[i][j] = 2;
        dfs(i + 1, j, matrix);
        dfs(i - 1, j, matrix);
        dfs(i, j + 1, matrix);
        dfs(i, j - 1, matrix);
    }
}
