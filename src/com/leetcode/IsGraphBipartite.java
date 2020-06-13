package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 29/05/2020
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<Integer>[] arr = new List[n];
        
        for (int i = 0; i < n; i++) {
            List<Integer> li = new ArrayList<>();
            for (int num : graph[i]) {
                li.add(num);
            }
            arr[i] = li;
        }
        
        int[] colors = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                colors[i] = 1;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.remove();
                    for (int neighbour : arr[cur]) {
                        if (colors[neighbour] == colors[cur]) return false;
                        if (colors[neighbour] == 0) {
                            queue.add(neighbour);
                            colors[neighbour] = -colors[cur];
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
