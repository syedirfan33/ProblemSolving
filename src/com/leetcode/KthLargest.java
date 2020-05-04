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
	
	public KthLargest(int k, int[] nums) {
		pq = new PriorityQueue<>(k);
		this.k = k;
		for(int num : nums) {
			add(num);
		}
	System.out.println(pq);
	}
	
	public int add(int val) {
		pq.add(val);
		if(pq.size() == k+1) {
			pq.remove();
		}
		System.out.println(pq);
		return pq.peek();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargest k = new KthLargest(3, new int[] {4,5,8,2});
		System.out.println(k.add(5));
	}

}
