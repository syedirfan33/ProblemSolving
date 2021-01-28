package com.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        List<Integer[]> res = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int diff = targetSum - (array[i] + array[j]);
                if (map.containsKey(diff)) {
                    List<Integer[]> li = map.get(diff);
                    for (Integer[] cur : li) {
                        res.add(new Integer[]{cur[0], cur[1], array[i], array[j]});
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int sum = array[i] + array[k];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<Integer[]>());
                }
                map.get(sum).add(new Integer[]{array[i], array[k]});
            }
        }
        return res;
    }
}
