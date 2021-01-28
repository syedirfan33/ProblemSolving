package com.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskAssignment {

    // nlogn time , I solved it myself. Better readable solution compared to algoexpert
    public ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < tasks.size(); i++) {
            minHeap.add(new int[]{i, tasks.get(i)});
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < tasks.size() / 2; i++) {
            res.add(new ArrayList<>());
            res.get(i).add(minHeap.remove()[0]);
        }
        for (int j = (tasks.size() / 2) - 1; j >= 0; j--) {
            res.get(j).add(minHeap.remove()[0]);
        }
        return res;
    }
}
