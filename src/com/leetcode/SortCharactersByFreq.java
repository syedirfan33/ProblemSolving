package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 22/05/2020
 */
public class  SortCharactersByFreq {
    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
    }

    public static String frequencySort(String s) {
        class Pair{
            char c;
            int count;

            public Pair(char c, int count) {
                this.c = c;
                this.count = count;
            }
        }

        StringBuilder res = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.count - a.count);
        map.forEach((k,v)->{
            maxHeap.add(new Pair(k, v));
        });

        while (!maxHeap.isEmpty()) {
            Pair cur = maxHeap.remove();
            while (cur.count > 0) {
                res.append(cur.c);
                cur.count--;
            }
        }
        return res.toString();
    }
}
