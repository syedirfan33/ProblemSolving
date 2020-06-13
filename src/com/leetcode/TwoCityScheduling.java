package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 03/06/2020
 */
public class TwoCityScheduling {
    
    //Min heap based solution
    public int twoCitySchedCost(int[][] costs) {
        int res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> (a[0] - a[1])));
        // or PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> ((a[0] - a[1]) - (b[0] - b[1])));
        Collections.addAll(minHeap, costs);
        for (int i = 0; i < costs.length / 2; i++) {
            res += minHeap.remove()[0];
        }
        for (int i = costs.length / 2; i < costs.length; i++) {
            res += minHeap.remove()[1];
        }
        return res;
    }
    
    //Array sort based solution
    public int twoCitySchedCost2(int[][] costs) {
        int res = 0;
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                res += costs[i][0];
            } else {
                res += costs[i][1];
            }
        }
        return res;
    }
}
