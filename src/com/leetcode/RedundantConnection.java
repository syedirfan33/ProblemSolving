package com.leetcode;

import java.util.*;

public class RedundantConnection {
    //Video from coding decoded / interview dose
    // Can be solved using DFS O(n2) and Union find - O(n))
    public int[] findRedundantConnection(int[][] edges) {
        //DFS approach

        int n = edges.length;
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            if (dfs(edge[0], edge[1], new HashSet<>(), adjList))
                return edge;
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return null;
    }

    private boolean dfs(int source, int target, Set<Integer> visited, Map<Integer, List<Integer>> adjList) {
        if (source == target)
            return true;
        visited.add(source);
        for (int other : adjList.get(source)) {
            if (!visited.contains(other)) {
                if (dfs(other, target, visited, adjList))
                    return true;
            }
        }
        return false;
    }
}
