package com.leetcode;

import java.util.Arrays;

public class TaskScheduler{
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for (char c : tasks) {
            arr[c - 'A']++;
        }
        Arrays.sort(arr);
        int chunks = arr[25] - 1;
        int idleSpots = chunks * n;
        for (int i = 24; i >= 0; i--) {
            idleSpots -= Math.min(chunks, arr[i]); // We could place chars only upto no. of chunks. Watch Naresh's video
        }
        return idleSpots > 0 ? tasks.length + idleSpots : tasks.length;
    }
}
