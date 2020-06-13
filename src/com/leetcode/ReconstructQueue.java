package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 07/06/2020
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new ArrayList<>();
        // for(int[] pair: people) list.add(pair);
        for(int i = 0; i < people.length; i++){
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}
