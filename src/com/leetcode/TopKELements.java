package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKELements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            int[] arr = {key, map.get(key)};
            maxHeap.add(arr);
        }
        int[] res = new int[k];
        int i = 0;
        while (i < k) {
            res[i] = maxHeap.remove()[0];
            i++;
        }
        return res;
    }
}
