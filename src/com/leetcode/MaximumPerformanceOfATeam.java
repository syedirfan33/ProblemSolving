package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {
    // Solution from coding decoded
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            players.add(new Player(speed[i], efficiency[i]));
        }

        Collections.sort(players, (a, b) -> Integer.compare(b.efficiency, a.efficiency));
        long res = 0, runningSpeed = 0;
        PriorityQueue<Player> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.speed, b.speed));
        for (Player current : players) {
            if (minHeap.size() == k) {
                Player least = minHeap.poll();
                runningSpeed -= least.speed;
            }
            minHeap.offer(current);
            runningSpeed += current.speed;
            res = Math.max(res, runningSpeed * current.efficiency);
        }
        return (int) (res % 100_00_00_007);
    }
}

class Player {
    int speed;
    int efficiency;

    Player(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}

// 1 5 2 10 3 8
// 9 7 5 4 3 2

// res = 42, speed = 5

// 3 2 100
// 7 5 3

