package com.leetcode;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    // Video from coding decoded - Dijkstra's algorithm
    public int swimInWater(int[][] grid) {
        int res = Integer.MIN_VALUE;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);

        minHeap.add(new int[]{0, 0});

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.remove();
            res = Math.max(res, grid[cur[0]][cur[1]]);
            if (cur[0] == grid.length - 1 && cur[1] == grid[0].length - 1)
                break;
            for (int[] dir : dirs) {
                int nextX = dir[0] + cur[0];
                int nextY = dir[1] + cur[1];

                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && visited[nextX][nextY] == false) {
                    visited[nextX][nextY] = true;
                    minHeap.add(new int[]{nextX, nextY});
                }
            }
        }
        return res;
    }
}
