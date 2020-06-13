package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 30/05/2020
 */
public class KClosestPointToOrigin {
    // beats 65%
    public int[][] kClosest(int[][] points, int K) {
        class Special{
            int distance;
            int[] pair;
            Special(int distance, int[] pair){
                this.distance = distance;
                this.pair = pair;
            }
        }
        List<int[]> res = new ArrayList<>();
        TreeMap<Double, List<int[]>> map = new TreeMap<>();
        PriorityQueue<Special> minHeap = new PriorityQueue<Special>(( a,  b) -> a.distance - b.distance);
        for(int[] pair: points){
            int dist = distance(pair);
            minHeap.add(new Special(dist, pair));
        }
        
        while(K > 0){
            
            res.add(minHeap.remove().pair);
            K--;
        }
        return res.toArray(new int[res.size()][]);
    }
    
    private int distance(int[] pair){
        int res1 = pair[0] * pair[0];
        int res2 = pair[1] * pair[1];
        return res1 + res2; //no need square root as it will also be same
    }
}
    // this solution was my first attempt, it worked!! 8 % leet code
//    public int[][] kClosest(int[][] points, int K) {
//        List<int[]> res = new ArrayList<>();
//        TreeMap<Double, List<int[]>> map = new TreeMap<>();
//        for(int[] pair: points){
//            double dist = distance(pair);
//            if(!map.containsKey(dist)){
//                map.put(dist, new ArrayList<>());
//            }
//            map.get(dist).add(pair);
//        }
//        for(double key: map.keySet()){
//            List<int[]> val = map.get(key);
//            for(int[] cur: val){
//                if(k > 0){
//                    res.add(cur);
//                }
//            }
//
//
//        }
//        return res.toArray(new int[res.size()][]);
//    }

