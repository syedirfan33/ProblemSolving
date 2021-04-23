package com.leetcode;

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            set.add(cur);
            List<Integer> next = rooms.get(cur);
            for (int n : next) {
                if (!set.contains(n)) queue.add(n);
            }
        }
        return set.size() == rooms.size();
    }
}
