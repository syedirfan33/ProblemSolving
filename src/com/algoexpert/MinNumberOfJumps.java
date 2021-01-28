package com.algoexpert;

public class MinNumberOfJumps {
    //Same as Jump game II leetcode
    public static int minNumberOfJumps(int[] array) {
        if (array.length <= 1) return 0;
        int maxJump = array[0];
        int steps = array[0];
        int jumps = 0;
        for (int i = 1; i < array.length - 1; i++) { // Last jump is of no use
            maxJump = Math.max(maxJump, i + array[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxJump - i; // Remaining steps you can take
            }
        }
        return jumps + 1;
    }
}
