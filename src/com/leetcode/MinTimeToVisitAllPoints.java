package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 14/06/2020
 */
public class MinTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int res = 0;
        int[] first = points[0];
        for (int i = 1; i < points.length; i++) {
            int[] second = points[i];
            int xChange = Math.abs(first[0] - second[0]);
            int yChange = Math.abs(first[1] - second[1]);
            res += Math.max(xChange, yChange);
            first = second;
        }
        return res;
    }
}