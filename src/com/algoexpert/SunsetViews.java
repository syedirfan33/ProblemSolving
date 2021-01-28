package com.algoexpert;

import java.util.ArrayList;

public class SunsetViews {
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int idx = "EAST".equals(direction) ? buildings.length - 1 : 0;
        if (direction.equals("EAST")) {
            while (idx >= 0) {
                if (buildings[idx] > max) {
                    max = buildings[idx];
                    res.add(0, idx);
                }
                idx--;
            }
        } else {
            while (idx < buildings.length) {
                if (buildings[idx] > max) {
                    max = buildings[idx];
                    res.add(idx);
                }
                idx++;
            }
        }
        return res;
    }
}
