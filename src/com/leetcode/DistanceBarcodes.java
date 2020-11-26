package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistanceBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        if (n <= 2) return barcodes;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) map.put(num, map.getOrDefault(num, 0) + 1);
        // Or we can user PriorityQueue<Entry<Integer, Integer>> for slightly faster result
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        int[] res = new int[n];
        // Because it's guaranteed that answer exists
        for (int i = 0; i < n; i++) {
            int cur1 = maxHeap.remove();
            if (i == 0 || res[i - 1] != cur1) {
                res[i] = cur1;
                if (map.get(cur1) > 1) {
                    map.put(cur1, map.get(cur1) - 1);
                    maxHeap.add(cur1);
                }
            } else {
                int cur2 = maxHeap.remove();
                res[i] = cur2;
                if (map.get(cur2) > 1) {
                    map.put(cur2, map.get(cur2) - 1);
                    maxHeap.add(cur2);
                }
                maxHeap.add(cur1);
            }
        }
        return res;
    }
}
