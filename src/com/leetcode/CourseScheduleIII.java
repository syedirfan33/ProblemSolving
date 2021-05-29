package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int totalTime = 0;
        for (int[] course : courses) {
            if (course[0] + totalTime <= course[1]) {
                totalTime += course[0];
                maxHeap.offer(course[0]);
            } else if (!maxHeap.isEmpty() && maxHeap.peek() > course[0]) {
                totalTime += course[0] - maxHeap.poll();
                maxHeap.offer(course[0]);
            }
        }
        return maxHeap.size();
    }
}
