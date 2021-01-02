package com.leetcode;

import java.util.PriorityQueue;

public class LongestHapppyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((first, second) -> second.count - first.count);
        if (a != 0) maxHeap.add(new Pair('a', a));
        if (b != 0) maxHeap.add(new Pair('b', b));
        if (c != 0) maxHeap.add(new Pair('c', c));

        while (maxHeap.size() > 1) {
            Pair first = maxHeap.remove();
            if (first.count > 1) {
                first.count -= 2;
                res.append(first.c).append(first.c);
            } else {
                first.count -= 1;
                res.append(first.c);
            }

            Pair second = maxHeap.remove();
            if (second.count > 1 && second.count > first.count) {
                second.count -= 2;
                res.append(second.c).append(second.c);
            } else {
                second.count -= 1;
                res.append(second.c);
            }
            if (first.count != 0) maxHeap.add(first);
            if (second.count != 0) maxHeap.add(second);
        }
        if (!maxHeap.isEmpty() && maxHeap.peek().c != res.charAt(res.length() - 1)) {
            Pair last = maxHeap.peek();
            if (last.count > 1) res.append(last.c).append(last.c);
            else res.append(last.c);
        }

        return res.toString();
    }

    class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
