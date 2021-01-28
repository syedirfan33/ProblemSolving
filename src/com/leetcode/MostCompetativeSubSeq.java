package com.leetcode;

import java.util.LinkedList;

public class MostCompetativeSubSeq {
    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int times = nums.length - k;
        for (int num : nums) {
            while (!queue.isEmpty() && queue.peekLast() > num && times > 0) {
                queue.removeLast();
                times--;
            }
            queue.addLast(num);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.removeFirst();
        }
        return res;
    }
}
