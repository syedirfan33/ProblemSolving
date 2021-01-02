package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckArrayFormation {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }
        int i = 0;
        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }
            int[] piece = map.get(arr[i]);
            for (int j = 0; j < piece.length; j++) {
                if (arr[i] != piece[j]) return false;
                i++;
            }
        }
        return true;
    }
}
