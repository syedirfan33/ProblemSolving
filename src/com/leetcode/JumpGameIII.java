package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {
    //Approach 1 : DFS
    // Instaed of set we could also mark current item as -ve to indicate that the index is already visited
    Set<Integer> set;
    public boolean canReach(int[] arr, int start) {
        set = new HashSet<>();
        return helper(arr, start);
    }

    boolean helper(int[] arr, int start){
        if(start < 0 || start >= arr.length || set.contains(start)) return false;
        if(arr[start] == 0) return true;
        set.add(start);
        return helper(arr, start + arr[start]) || helper(arr, start - arr[start]);
    }


    boolean helperII(int[] arr, int start){
        if(start < 0 || start >= arr.length || arr[start] < 0) return false;
        if(arr[start] == 0) return true;
        arr[start] = -arr[start];
        return helper(arr, start + arr[start]) || helper(arr, start - arr[start]);
    }

    // BFS solution
    public boolean canReachII(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int index = queue.remove();
            if(arr[index] == 0) return true;
            if(arr[index] < 0) continue; // The index is already visited.
            if(index + arr[index] < arr.length) queue.add(index + arr[index]);// Jump forward
            if(index - arr[index] >= 0) queue.add(index - arr[index]);
            arr[index] = -arr[index];
        }
        return false;
    }
}
