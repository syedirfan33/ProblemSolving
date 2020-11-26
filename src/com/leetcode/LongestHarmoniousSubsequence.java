package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    // Two pass solution
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        int res = 0;
        for(int num: nums){
            if(map.containsKey(num + 1)){
                res = Math.max(map.get(num) + map.get(num + 1), res);
            }
        }
        return res;
    }

    //One pass clever solution
    public int findLHSII(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0) + 1);

            if(map.containsKey(num + 1)){
                res = Math.max(map.get(num) + map.get(num + 1), res);
            }
            if(map.containsKey(num - 1)){
                res = Math.max(map.get(num) + map.get(num - 1), res);
            }

        }
        return res;
    }
}
