/**
 *
 */
package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan
 *
 */
public class CourseSelection {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    // See below for optimised approach, just need slight modification based on adj list technique
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int count = 0;

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) stack.push(i);
        }

        while (!stack.isEmpty()) {
            int current = stack.pop();
            count++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == current) {
                    inDegree[prerequisite[0]]--;
                    if (inDegree[prerequisite[0]] == 0) stack.push(prerequisite[0]);
                }
            }
        }

        return count == numCourses;
    }

    public boolean canFinishII(int numCourses, int[][] prerequisites) {
        int completedSoFar = 0;

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

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            completedSoFar++;
            for (int next : adjList.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }
        return completedSoFar >= numCourses;
    }
}
