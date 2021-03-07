package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                if (cur[0] == m - 1 && cur[1] == n - 1) return res;
                if (grid[cur[0]][cur[1]] == 1) continue;
                grid[cur[0]][cur[1]] = 1; // We can also mark node as visited as soon as we added element in queue.
                for (int[] d : dir) {
                    int nextX = d[0] + cur[0];
                    int nextY = d[1] + cur[1];
                    if (isValid(grid, nextX, nextY)) queue.add(new int[]{nextX, nextY});
                }

            }
            res++;
        }
        return -1;
    }


    private boolean isValid(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 1)
            return false;
        return true;

    }
}
