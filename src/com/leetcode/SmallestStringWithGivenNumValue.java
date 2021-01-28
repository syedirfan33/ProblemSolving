package com.leetcode;

import java.util.Arrays;

public class SmallestStringWithGivenNumValue {
    // I solved it myself. Greedy approach.
    // 73 consider n = 5, k 73
    // So initially we fill out by a a a a a (imagine out = (1 1 1 1 1), so, we do k -= n;
    // Finally we iterate from last. Ou t becomes 1 1 1 18 26 26
    public String getSmallestString(int n, int k) {
        char[] out = new char[n];
        Arrays.fill(out, 'a');
        k -= n;
        int i = n - 1;
        while (k > 0) {
            if (k >= 26) {
                k -= 25; // it's 25 because we already did k -= n;
                out[i] = 'z';
                i--;
            } else {
                out[i] = (char) (k + 'a');
                break;
            }

        }
        return new String(out);
    }
}
