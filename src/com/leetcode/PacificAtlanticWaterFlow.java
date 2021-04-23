package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    // Video from coding decoded or Algorithms made easy
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacific, Integer.MIN_VALUE);

            dfs(matrix, m - 1, j, atlantic, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific, Integer.MIN_VALUE);

            dfs(matrix, i, n - 1, atlantic, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] ocean, int prev) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length)
            return;
        if (ocean[i][j] || matrix[i][j] < prev)
            return;
        ocean[i][j] = true;
        dfs(matrix, i, j + 1, ocean, matrix[i][j]);
        dfs(matrix, i, j - 1, ocean, matrix[i][j]);
        dfs(matrix, i + 1, j, ocean, matrix[i][j]);
        dfs(matrix, i - 1, j, ocean, matrix[i][j]);
    }
}
