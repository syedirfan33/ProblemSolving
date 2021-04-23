/**
 *
 */
package com.algoexpert;

import java.util.*;

/**
 * @author Syed Irfan
 *
 */
public class MinNoOfCoinsForChange {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(1 + Integer.MAX_VALUE);

    }

    public static int minNoOfCoildForChange(int n, int[] denoms) {
        int[] minCoins = new int[n + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        LinkedList<Integer> q = new LinkedList<>();
        minCoins[0] = 0;
        for (int denom : denoms) {
            for (int amount = 1; amount < minCoins.length; amount++) {
                if (denom <= amount) {
                    if (minCoins[amount - denom] != Integer.MAX_VALUE) {
                        minCoins[amount] = Math.min(minCoins[amount], 1 + minCoins[amount - denom]);
                    }
                }
            }
        }
        return minCoins[n] == Integer.MAX_VALUE ? -1 : minCoins[n];
    }
}
