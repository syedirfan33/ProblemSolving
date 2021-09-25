package com.leetcode;

import java.util.PriorityQueue;

public class FindMedianOfDataStream {
    /**
     * Video from coding decoded
     */
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public FindMedianOfDataStream() {
        minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
    }

    public void addNum(int num) {
        if (maxHeap.size() == 0 || maxHeap.peek() >= num)
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        balance();
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    private void balance() {
        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
