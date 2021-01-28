package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumIncreasingSubseq {
    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array) {
        List<List<Integer>> res = new ArrayList<>();
        int[] dp = new int[array.length];
        int[] idx = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            dp[i] = array[i]; // Or can use array.clone
        }
        Arrays.fill(idx, -1);
        int maxSum = array[0], maxIdx = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    int prevMax = dp[i];
                    dp[i] = Math.max(prevMax, dp[j] + array[i]);

                    if (dp[i] > prevMax) idx[i] = j;
                    if (dp[i] > maxSum) {
                        maxSum = dp[i];
                        maxIdx = i;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(idx));
        return buildRes(maxSum, maxIdx, array, idx);
    }

    private static List<List<Integer>> buildRes(int maxSum, int maxIdx, int[] array, int[] idx) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(maxSum));
        List<Integer> indexes = new ArrayList<>();
        while (maxIdx != -1) {
            indexes.add(0, array[maxIdx]);
            maxIdx = idx[maxIdx];
        }
        res.add(indexes);
        return res;
    }
}
