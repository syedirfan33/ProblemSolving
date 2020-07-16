package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Syed Irfan - 21/06/2020
 */
public class MeetingRoomsII {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, (a, b) -> a.get(0) - b.get(0));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(A.get(0).get(1));
        for(int i = 1; i < A.size(); i++){
            if(minHeap.peek() <= A.get(i).get(0)){
                minHeap.remove();
            }
            
            minHeap.add(A.get(i).get(1));
        }
        return minHeap.size();
    }
}
