package com.algoexpert;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortKSortedArray {
    // O(nlogk)
    public int[] sortKSortedArray(int[] array, int k) {
        int len = array.length;
        int[] res = new int[array.length];
        if (k >= len) {
            Arrays.sort(array);
            return array;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        while (i <= k) minHeap.add(array[i++]);
        int l = 0;
        for (int j = k + 1; j < array.length; j++) {
            res[l++] = minHeap.remove();
            minHeap.add(array[j]); // minheap at max holds k + 1 elements only
        }
        while (!minHeap.isEmpty()) res[l++] = minHeap.remove();
        return res;
    }
}
