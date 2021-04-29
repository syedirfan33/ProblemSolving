package com.leetcode;

import java.util.PriorityQueue;

public class FarthestBuildingUCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int bricksUsed = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                minHeap.offer(heights[i] - heights[i - 1]);
                if (minHeap.size() > ladders) {
                    int min = minHeap.poll();
                    bricksUsed += min;
                }
                if (bricksUsed > bricks)
                    return i - 1;
            }
        }
        return heights.length - 1; // 0 indexed
    }
}
