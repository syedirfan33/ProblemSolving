package com.leetcode;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        if (tokens.length == 0 || P < tokens[0]) return 0;
        //int n = tokens.length
        int max = 0;
        int res = 0;
        int left = 0, right = tokens.length - 1;
        while (left <= right) {
            if (P >= tokens[left]) {
                P -= tokens[left];
                left++;
                res++;
            } else {
                P += tokens[right];
                right--;
                res--;
            }
            max = Math.max(res, max);
        }
        return max;
    }
}
