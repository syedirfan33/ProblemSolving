package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Syed Irfan - 29/05/2020
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (colors[i] != 0) continue;
            queue.add(i);
            colors[i] = 1;
            while (!queue.isEmpty()) {
                int cur = queue.remove();
                for (int adj : graph[cur]) {
                    if (colors[adj] == 0) {
                        colors[adj] = -colors[cur];
                        queue.add(adj);
                    } else if (colors[cur] == colors[adj]) return false;
                }
            }
        }
        return true;
    }
}
