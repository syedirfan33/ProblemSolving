package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Syed Irfan - 04/07/2020
 */
public class PrisonCells {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Set<String> set = new HashSet<>();
        boolean hasCycle = false;
        for (int i = 1; i <= N; i++) {
            int[] nextArr = getNext(cells);
            String nextCells = Arrays.toString(nextArr);
            if (set.contains(nextCells)) {
                hasCycle = true;
                break;
            }
            set.add(nextCells);
            cells = nextArr;
        }
        
        if (hasCycle) {
            int n = N % set.size();
            for (int i = 0; i < n; i++) {
                cells = getNext(cells);
            }
        }
        return cells;
    }
    
    private int[] getNext(int[] cells) {
        int[] next = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                next[i] = 1;
            }
        }
        return next;
    }
}

