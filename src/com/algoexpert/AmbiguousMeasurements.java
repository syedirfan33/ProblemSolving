package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class AmbiguousMeasurements {

    // Solved it myself, just need to add memoization. see solution 2
    boolean res = false;

    public boolean ambiguousMeasurements(int[][] measuringCups, int low, int high) {
        helper(measuringCups, 0, low, high, 0, 0);
        return res;
    }

    private void helper(int[][] measuringCups, int idx, int low, int high, int curLow, int curHigh) {
        if (curLow >= low && curHigh <= high || res) {
            res = true;
            return;
        }
        if (curLow >= high || curHigh > high)
            return;
        for (int i = idx; i < measuringCups.length; i++) {
            int[] cur = measuringCups[i];
            helper(measuringCups, i, low, high, curLow + cur[0], curHigh + cur[1]);
        }
    }

    Map<String, Boolean> map = new HashMap<>();

    public boolean ambiguousMeasurementsII(int[][] measuringCups, int low, int high) {
        return helperII(measuringCups, 0, low, high, 0, 0);
    }

    private boolean helperII(int[][] measuringCups, int idx, int low, int high, int curLow, int curHigh) {
        String key = curLow + ":" + curHigh;
        if (map.containsKey(key))
            return map.get(key);
        if (curLow >= low && curHigh <= high) {
            return true;
        } else if (curLow >= high || curHigh > high)
            return false;
        boolean curRes = false;
        for (int i = idx; i < measuringCups.length; i++) {
            int[] cur = measuringCups[i];
            curRes = helperII(measuringCups, i, low, high, curLow + cur[0], curHigh + cur[1]);
            if (curRes) {
                map.put(key, curRes);
                break;
            }
        }
        map.put(key, curRes);
        return curRes;
    }
}
