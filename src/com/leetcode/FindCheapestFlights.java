package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 14/06/2020
 */
public class FindCheapestFlights {
    
    public static void main(String[] args) {
        int[][] inp = {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
    
        findCheapestPrice(5, inp, 0, 4, 1);
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<int[]>[] routes = new List[n];
        //Arrays.fill(routes, new ArrayList<>());
        for (int[] pair : flights) {
            if (routes[pair[1]] == null) routes[pair[1]] = new ArrayList<>();
            routes[pair[1]].add(new int[]{pair[0], pair[2]});
        }
        int res = Integer.MAX_VALUE;
        //[[0,1,100],[1,2,100],[0,2,500]]
        if (routes[dst].size() == 0) return -1;
        // List<int[]> allRoutes = routes[dst];
        System.out.println(Arrays.deepToString(routes[dst].toArray()));
        
        for (int[] route : routes[dst]) {
            int curCost = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(route);
            System.out.println("Adding" + Arrays.toString(route));
            while (K > 0 && !queue.isEmpty() && queue.peek()[0] != src) {
                int[] cur = queue.remove();
                curCost += cur[1];
                K--;
                List<int[]> next = routes[cur[0]];
                queue.addAll(next);
            }
            
            while(!queue.isEmpty() && queue.peek()[0] != src){
                queue.remove();
            }
            if(queue.isEmpty()) continue;
            int[] last = queue.remove();
            curCost += last[1];
            res = Math.min(res, curCost);
        }
        System.out.println(res);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
