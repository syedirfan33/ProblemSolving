package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan - 21/06/2020
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        int[] perm = new int[n+1];
        perm[0] = 1;
        digits.add(0);
        for(int i = 1; i <= n ; i++){
            digits.add(i);
            perm[i] = i * perm[i-1];
        }
        StringBuilder res = new StringBuilder();
        while(n >= 1 ){
            int blocks = perm[n] / n; // or perm[n-1];
            int index = k % blocks == 0 ? (k/blocks)  : (k / blocks) + 1;
            res.append(digits.get(index));
            digits.remove(index);
            int steps = k % blocks == 0 ? (k/blocks) - 1 : k / blocks;
            k = k - (blocks * steps);
            n--;
        }
        return res.toString();
    }
}
