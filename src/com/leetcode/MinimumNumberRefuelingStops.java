package com.leetcode;

import java.util.PriorityQueue;

public class MinimumNumberRefuelingStops {
    //video from codeWithSunny and coding decoded
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int maxStop = startFuel;
        int stops = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int[] station : stations) {
            while (maxStop < station[0]) {
                if (maxHeap.isEmpty())
                    return -1;
                maxStop += maxHeap.poll();
                stops++;
            }
            maxHeap.offer(station[1]);StringBuilder s = new StringBuilder(); s.reverse();s.deleteCharAt(1);
            if (maxStop >= target)
                return stops;
        }
        while (maxStop < target) {
            if (maxHeap.isEmpty())
                return -1;
            maxStop += maxHeap.poll();
            stops++;
        }
        return stops;
    }
}
