package com.leetcode;

import java.util.Random;

public class ShuffleArray {
    //Solution from coding decoded
    int[] numsArr;
    Random rand;

    public ShuffleArray(int[] nums) {
        numsArr = nums;
        rand = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return numsArr;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuffled = numsArr.clone();
        for (int i = numsArr.length - 1; i > 0; i--) {
            int idx = rand.nextInt(i + 1);
            int temp = shuffled[idx];
            shuffled[idx] = shuffled[i];
            shuffled[i] = temp;
        }
        return shuffled;
    }
}
