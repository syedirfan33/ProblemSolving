package com.leetcode;

import java.util.Map;
import java.util.PriorityQueue;

public class CapacityToShipPackagesInDDays {
    /*The key is left = max(weights), right = sum(weights),
    which are the minimum and maximum possible weight capacity of the ship.

    Therefore the question becomes Binary Search to find the minimum weight capacity of the ship between left and right.
    We start from
            mid = (left + right) / 2 as our current weight capacity of the ship.
    need = days needed == 1
    cur = current cargo in the ship == 0

    Start put cargo into ship in order.
    when need > D, it means the current ship is too small, we modify left = mid + 1 and continue
    If all the cargo is successfully put into ships, we might have a chance to find a smaller ship, so let right = mid and continue.
    Finally, when our left == right, we reach our answer*/
    public int shipWithinDays(int[] weights, int D) {
        int minW = 0, maxW = 0;
        for (int w : weights) {
            maxW += w;
            minW = Math.max(minW, w);
        }
        while (minW < maxW) {
            int midW = minW + (maxW - minW) / 2, days = 1, sum = 0;
            for (int w : weights) {
                sum += w;
                if (sum > midW) {
                    days++;
                    sum = w;
                }
            }
            if (days > D) { // If no. of days are more, that means that we have to increase the result (minimum weight)
                minW = midW + 1;
            } else {
                maxW = midW;
            }
        }
        return minW;
    }
}
