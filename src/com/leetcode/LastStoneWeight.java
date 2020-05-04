/**
 * 
 */
package com.leetcode;

import java.util.PriorityQueue;

/**
 * @author Syed Irfan
 *
 */
public class LastStoneWeight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lastStoneWeight(int[] stones) {
        if(stones.length == 0) return 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b-a);
        
        for(int stone: stones){
            maxHeap.add(stone);
        }
        
        while(maxHeap.size()>1){
            int stone1 = maxHeap.remove();
            int stone2 = maxHeap.remove();
            if(stone1!=stone2){
                maxHeap.add(stone1 - stone2);
            }
        }
        return maxHeap.size() > 0 ? maxHeap.remove() : 0;
    }
	
}
