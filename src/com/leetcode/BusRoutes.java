package com.leetcode;

import java.util.*;

// I code it out after seeing video in youtube, it's easy
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int[] cur = routes[i];
            for (int route : cur) {
                if (!map.containsKey(route)) {
                    map.put(route, new ArrayList<>());
                }
                map.get(route).add(i);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == T) return cur[1];
            if (visited.contains(cur[0])) continue;
            List<Integer> curRoutes = map.get(cur[0]);
            for (int curRoute : curRoutes) {
                if (routes[curRoute].length > 0) {
                    for (int i = 0; i < routes[curRoute].length; i++) {
                        queue.add(new int[]{routes[curRoute][i], cur[1] + 1});
                    }
                    routes[curRoute] = new int[]{};
                }
            }
            visited.add(cur[0]);
        }
        return -1;
    }
}
