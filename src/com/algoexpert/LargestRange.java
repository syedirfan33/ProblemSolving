package com.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        Map<Integer, Boolean> map = new HashMap<>();
        int maxRange = 0;
        int[] res = new int[2];
        for(int num: array){
            map.put(num, false);
        }
        for(int num: array){
            if(map.get(num)) continue; // The num is already visited. That's why TC - O(n)
            int minVal = num - 1;
            while(map.containsKey(minVal)){
                map.put(minVal, true);
                minVal--;
            }
            int maxVal = num + 1;
            while(map.containsKey(maxVal)){
                map.put(maxVal, true);
                maxVal++;
            }
            int range = (maxVal - 1) - (minVal + 1) + 1; // Understand lah, with an ex.
            if(range > maxRange){
                maxRange = range;
                res = new int[]{minVal + 1, maxVal - 1};
            }
        }
        return res;
    }
}
