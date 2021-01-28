package com.algoexpert;

import java.util.Arrays;

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int res = 0;
        int sum = 0;
        for (int i = 1; i < queries.length; i++) {
            res += queries[i - 1];
            sum += res;
        }
        return sum;
    }
}
