package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BInaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);
        long res = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int remain = arr[i] / arr[j];
                    if (map.containsKey(remain)) {
                        dp[i] += dp[j] * dp[map.get(remain)];
                    }
                }
            }
            res += dp[i];
        }
        //System.out.println(Arrays.toString(dp));
        return (int) (res % 1_00_000_0007);
    }
}
