package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinEffort {
    // Dijkstra's algorithm
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int column = heights[0].length;
        boolean[][] visited = new boolean[row][column];
        int[][] minEffort = new int[row][column];
        for(int[] e: minEffort){
            Arrays.fill(e, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        minHeap.add(new int[]{0,0,0}); // Effort is 0 for starting point
        minEffort[0][0] = 0;
        int[][] dir = {{0,1}, {1, 0}, {0, -1}, {-1,0}};
        // Min heap will always have lowest effort item first
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.remove();
            int x = cur[0], y = cur[1];
            if(x == row - 1 && y == column - 1){
                return cur[2];
            }
            visited[x][y] = true;
            for(int[] d : dir){
                int nx = x + d[0];
                int ny= y + d[1];
                if(nx < 0 || nx >= row || ny < 0 || ny >= column || visited[nx][ny]) continue;
                // This is very important
                int nextEffort = Math.max(Math.abs(heights[nx][ny] - heights[x][y]), minEffort[x][y]);
                if(nextEffort < minEffort[nx][ny]){
                    minEffort[nx][ny] = nextEffort;
                    minHeap.add(new int[]{nx, ny, nextEffort});
                }
            }
        }
        return -1;
    }
}
