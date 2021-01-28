package com.algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasAlgorithm {
    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] costs = new int[edges.length];
        Arrays.fill(costs, Integer.MAX_VALUE);
        minHeap.add(new int[]{start, 0});
        costs[start] = 0;
        while (!minHeap.isEmpty()) {
            // It's very important to know when to stop in dijkstras
            if (visited.size() == edges.length) break;
            int[] cur = minHeap.remove();
            visited.add(cur[0]);
            int[][] nextEdges = edges[cur[0]];
            for (int[] edge : nextEdges) {
                if (visited.contains(edge[0])) continue;
                int edgeCost = edge[1] + cur[1];
                if (costs[edge[0]] > edgeCost) {
                    costs[edge[0]] = edgeCost;
                    minHeap.add(new int[]{edge[0], edgeCost});
                }
            }
        }
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] == Integer.MAX_VALUE) costs[i] = -1;
        }
        System.out.println(Arrays.toString(costs));
        return costs;
    }
}
