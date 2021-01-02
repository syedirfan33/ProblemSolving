package com.leetcode;

import java.util.*;

public class HandOfStraights {

    // My solution using Priority Queue((O(NlogN), but using TreeMap, code can be reduced and also efficiency can be slightly improved
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Map<Integer, int[]> map = new HashMap<>();
        for(int h: hand){
            if(!map.containsKey(h)) map.put(h, new int[]{h, 0});
            map.get(h)[1]++;
        }
        minHeap.addAll(map.values());

        int res = 0;
        List<int[]> cur = new ArrayList<>();
        int num = W;
        while(num != 0){
            if(minHeap.isEmpty()) break;
            if(cur.size() > 0 && cur.get(cur.size() - 1)[0] + 1 != minHeap.peek()[0]) break;
            int[] pair = minHeap.remove();
            pair[1]--;
            cur.add(pair);
            num--;
            if(num == 0){
                num = W;
                for(int[] p: cur){
                    if(p[1] > 0) minHeap.add(p);
                }
                cur = new ArrayList<>();
                res++;
            }
        }
        return hand.length / W == res;
    }

    // O(nlogn) solution
    public boolean isNStraightHandII(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h: hand){
            map.put(h, map.getOrDefault(h, 0) + 1);
        }
        int res = 0;
        while(map.size() > 0){
            int key = map.firstKey();
            for(int j = 0; j < W; j++){
                if(!map.containsKey(key + j)) return false;
                if(map.get(key + j) == 1) map.remove(key + j);
                else map.put(key + j, map.get(key + j) - 1);
            }

        }
        return true;
    }
}
