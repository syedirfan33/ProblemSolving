package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSrcToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(res, cur, graph, 0, graph.length - 1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> cur, int[][] graph, int source, int destination) {
        if (source == destination) {
            List<Integer> path = new ArrayList<>(cur);
            res.add(path);
            return;
        }
        for (int node : graph[source]) {
            cur.add(node);
            dfs(res, cur, graph, node, destination);
            cur.remove(cur.size() - 1);
        }
    }
}
