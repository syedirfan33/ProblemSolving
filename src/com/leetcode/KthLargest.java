/**
 * 
 */
package com.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Syed Irfan
 *
 */
public class KthLargest {

	private Queue<Integer> pq;
	private int k;
	
	public int KthLargest(int k, int[] nums) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int num: nums){
			minHeap.add(num);
			if(minHeap.size() > k) minHeap.remove();
		}
		return minHeap.peek();
	}
}
