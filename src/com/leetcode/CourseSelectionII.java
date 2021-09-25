package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSelectionII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            indegree[arr[0]]++;
            adjList.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }
        int[] res = new int[numCourses];
        int idx = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res[idx++] = cur;
            for (int next : adjList.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        if (idx < numCourses) return new int[]{};
        return res;
    }


}
