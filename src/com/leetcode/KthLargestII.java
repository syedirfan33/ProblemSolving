/**
 * 
 */
package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author Syed Irfan
 *
 */
public class KthLargestII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        for(int num: nums){
	            minHeap.add(num);
	            if(minHeap.size() > k){
	                minHeap.remove();
	            }
	        }
	        System.out.println();
	        return minHeap.remove();
	    }

}
