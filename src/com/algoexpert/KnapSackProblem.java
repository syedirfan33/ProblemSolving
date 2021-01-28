package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KnapSackProblem {

    //	0  1	 2  3  4. 5. 6. 7  8  9  10
//[[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],   []
// [0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1],   1 2
// [0, 0, 1, 4, 4, 5, 5, 5, 5, 5, 5],   4 3
// [0, 0, 1, 4, 4, 5, 5, 5, 6, 9, 9],   5 6
// [0, 0, 1, 4, 4, 5, 5, 6, 6, 9, 10]]  6 7

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        int[][] dp = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < dp.length; i++) {
            int curValue = items[i - 1][0];
            int curWeight = items[i - 1][1];
            for (int j = 0; j < dp[0].length; j++) {
                if (curWeight > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], curValue + dp[i - 1][j - curWeight]);
                }
            }
        }
        return buildRes(items, dp);
    }

    private static List<List<Integer>> buildRes(int[][] items, int[][] dp) {
        List<List<Integer>> res = new ArrayList<>();
        int row = dp.length - 1;
        int column = dp[0].length - 1;
        res.add(Arrays.asList(dp[row][column]));
        List<Integer> resItems = new ArrayList<>();
        while (row > 0) {
            if (dp[row][column] != dp[row - 1][column]) {
                resItems.add(0, row - 1);
                column -= items[row - 1][1];
                row--;
            } else {
                row--;
            }
            if (column == 0) break;
        }
        res.add(resItems);
        return res;
    }
}


