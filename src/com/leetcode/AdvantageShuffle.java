package com.leetcode;

import java.util.*;

public class AdvantageShuffle {
    // Video from algorithms made easy, see comments to know more consice PQ based solution
    public int[] advantageCount(int[] A, int[] B) {
        Map<Integer, Queue<Integer>> map = new HashMap<>(); // map to store index of B, used q coz, B might contains duplicates
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) map.put(B[i], new LinkedList<>());
            map.get(B[i]).add(i); // Storing B's indexes
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;
        int[] res = new int[A.length];
        Arrays.fill(res, -1);

        Queue<Integer> unused = new LinkedList<>();
        while (i < A.length && j < B.length) {
            if (A[i] > B[j]) {
                int idx = map.get(B[j]).remove();
                res[idx] = A[i];
                j++;
            } else {
                unused.add(A[i]);
            }
            i++;
        }
        for (int k = 0; k < res.length; k++) {
            if (res[k] == -1) res[k] = unused.remove();
        }
        return res;
    }

    // A good solution
    public int[] advantageCountII(int[] A, int[] B) {
        Arrays.sort(A);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < B.length; i++){
            minHeap.add(new int[]{B[i], i});
        }
        int[] res = new int[A.length];
        int left = 0, right = A.length - 1;
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.remove();
            if(A[right] > cur[0]){
                res[cur[1]] = A[right];
                right--;
            }else{
                res[cur[1]] = A[left];
                left++;
            }
        }
        return res;
    }
}
