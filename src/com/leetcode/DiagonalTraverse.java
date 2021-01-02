package com.leetcode;

import java.util.*;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int sum = i + j;
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<>());
                }
                map.get(sum).add(matrix[i][j]);
            }
        }

        int[] res = new int[matrix.length * matrix[0].length];
        int i = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> cur = entry.getValue();
            if (entry.getKey() % 2 == 0) {
                Collections.reverse(cur);
            }
            for (int num : cur)
                res[i++] = num;
        }
        return res;
    }
}
