package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class QueensThatCanAttackKing {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, 0}, {-1, 0}, {1, -1}, {-1, 1}};
        boolean[][] q = new boolean[8][8];
        for (int[] queen : queens) {
            q[queen[0]][queen[1]] = true;
        }

        int i = king[0];
        int j = king[1];

        List<List<Integer>> res = new ArrayList<>();
        for (int[] dir : dirs) {
            for (int k = 1; k < 8; k++) {
                int newI = i + (dir[0] * k);
                int newJ = j + (dir[1] * k);
                if (newI >= 0 && newI < 8 && newJ >= 0 && newJ < 8 && q[newI][newJ] == true) {
                    List<Integer> cur = new ArrayList<>();
                    cur.add(newI);
                    cur.add(newJ);
                    res.add(cur);
                    break; // No need to explore other value for current K
                }
            }
        }
        return res;
    }

}
