package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Syed Irfan - 22/05/2020
 */
public class RiverSizes {
    public static void main(String[] args) {
        int[][] input = {{1, 0, 0, 1, 0},
                         {1, 0, 1, 0, 0},
                         {0, 0, 1, 0, 1},
                         {1, 0, 1, 0, 1},
                         {1, 0, 1, 1, 0}};
        riverSizes(input);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 1) {
                    int rivers = dfs(matrix, i, j, 0);
                    res.add(rivers);
                }
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
        return res;

    }

    private static int dfs(int[][] matrix, int i, int j, int sum) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] == 0) {
            return sum;
        }
        sum += 1;
        matrix[i][j] = 0;
        sum = dfs(matrix, i + 1, j, sum);
        sum = dfs(matrix, i, j + 1, sum);
        sum = dfs(matrix, i - 1, j, sum);
        sum = dfs(matrix, i, j - 1, sum);
        return sum;
    }
}
