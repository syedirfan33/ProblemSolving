package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinNumberOfDaysToEatNOranges {
    Map<Integer, Integer> memo = new HashMap<>();
    public int minDays(int n) {
        memo.put(1, 1);
        memo.put(2, 2);
        memo.put(3, 2);
        dfs(n);
        return memo.get(n);
    }

    // My sol, got TLE
    private int dfs(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int days3 = n % 2 == 0 ? 1 + dfs(n / 2) : n;
        int days2 = n % 3 == 0 ? 1 + dfs(n / 3) : n;
        int days1 = 1 + dfs(n - 1);
        int res = Math.min(days1 , Math.min(days2, days3));
        memo.put(n, res);
        return res;
    }


    public int minDaysII(int n) {
        memo.put(1, 1);
        memo.put(2, 2);
        memo.put(3, 2);
        dfsII(n);
        return memo.get(n);
    }

    private int dfsII(int n){
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int res = n;
        if(n % 3 == 0 && n % 2 == 0){
            res = Math.min(1 + dfsII(n / 3), 1 + dfsII(n / 2));
        }else if(n % 3 == 0){
            res = Math.min(1 + dfsII(n / 3), 1 + dfsII(n - 1));
        }else if(n % 2 == 0){
            res = Math.min(1 + dfsII(n / 2), 1 + dfsII(n - 1));
        }else{
            res = 1 + dfsII(n - 1);
        }
        memo.put(n, res);
        return res;
    }
}
