package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSum {

    //SOl 1 - O(n^2);
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> (a.get(0) + a.get(1)) - (b.get(0) + b.get(1)));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> cur = new ArrayList<>();
                cur.add(nums1[i]);
                cur.add(nums2[j]);
                minHeap.add(cur);

            }
        }
        while (!minHeap.isEmpty()) {
            res.add(minHeap.remove());
            if (res.size() == k) return res;
        }
        return res;
    }
}
