package com.leetcode;

public class MinimumCostToMoveChipsToSamePosition {
    // I am happy to come up with this solution on my own after drawing test case on a white paper
    public int minCostToMoveChips(int[] position) {
        int oddChips = 0;
        int evenChips = 0;
        for (int num : position) {
            if (num % 2 == 0) evenChips++;
            else oddChips++;
        }
        return Math.min(oddChips, evenChips);
    }
}
