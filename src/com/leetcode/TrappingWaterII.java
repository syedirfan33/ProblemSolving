package com.leetcode;

import java.util.PriorityQueue;

public class TrappingWaterII {
    class Cell {
        int row, column, height;

        Cell(int row, int column, int height) {
            this.row = row;
            this.column = column;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length <= 2) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            Cell cur1 = new Cell(i, 0, heightMap[i][0]);
            Cell cur2 = new Cell(i, n - 1, heightMap[i][n - 1]);
            visited[i][0] = true;
            visited[i][n - 1] = true;
            queue.add(cur1);
            queue.add(cur2);
        }

        for (int i = 0; i < n; i++) {
            Cell cur1 = new Cell(0, i, heightMap[0][i]);
            Cell cur2 = new Cell(m - 1, i, heightMap[m - 1][i]);
            visited[0][i] = true;
            visited[m - 1][i] = true;
            queue.add(cur1);
            queue.add(cur2);
        }

        int max = Integer.MIN_VALUE;
        int res = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!queue.isEmpty()) {
            Cell cur = queue.remove();
            max = Math.max(max, cur.height);
            for (int[] dir : dirs) {
                int row = dir[0] + cur.row;
                int column = dir[1] + cur.column;
                if (row <= 0 || row >= m - 1 || column <= 0 || column >= n - 1 || visited[row][column] == true)
                    continue;
                Cell newCell = new Cell(row, column, heightMap[row][column]);
                visited[row][column] = true;
                queue.add(newCell);
                if (newCell.height < max) res += max - newCell.height;
            }
        }

        return res;
    }
}
