package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.IntStream;

public class CourseSelectionII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            res[idx++] = cur;
            for (int[] pair : prerequisites) {
                if (cur == pair[1]) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) queue.add(pair[0]);
                }
            }
        }
        if (idx != numCourses) {
            return new int[]{};
        }
        return res;
    }
}
