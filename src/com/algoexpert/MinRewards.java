package com.algoexpert;

import java.util.Arrays;

public class MinRewards {
    public static int minRewards(int[] scores) {
        int[] res = new int[scores.length];
        Arrays.fill(res, 1);
        // This iteration for increasing sequence only
        for (int i = 1; i < scores.length; i++) {
            if (scores[i - 1] > scores[i]) {
                continue;
            } else {
                res[i] = res[i - 1] + 1;
            }
        }
        System.out.println(Arrays.toString(res));
        // this iteration for decreasing sequence
        for (int i = scores.length - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1]) {
                res[i] = Math.max(res[i], res[i + 1] + 1);
            }
        }
        System.out.println(Arrays.toString(res));
        int out = 0;
        for (int num : res) out += num;
        return out;
    }
}
