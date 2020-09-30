package com.leetcode;

import java.util.*;

public class EvaludateDivision {
    class Node {
        String key;
        double value;

        public Node(String key, double value) {
            this.key = key;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = getGraph(equations, values);
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet());
        }

        return res;
    }

    private double dfs(String src, String dest, Map<String, List<Node>> graph, HashSet<String> visited) {
        if (!(graph.containsKey(src) && graph.containsKey(dest))) return -1.0;
        if (src.equals(dest)) return 1.0;
        visited.add(src);
        for (Node node : graph.get(src)) {
            if (!visited.contains(node.key)) {
                double res = dfs(node.key, dest, graph, visited);
                if (res != -1.0) return res *= node.value;
            }
        }
        return -1.0;
    }

    private Map<String, List<Node>> getGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList());
            graph.putIfAbsent(dest, new ArrayList());
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }


}
