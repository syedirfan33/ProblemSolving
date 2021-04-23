package com.leetcode;

public class ValidBoomerang {
    // I did remember the formula to find slope correctly. What I did was , finding slopes of a1 nd a2 and a2 and a3, and then compare slope1 != slope2
    // but it gave divide by 0 error. So we can use cross multiplication instead of division
    // (x2 - x1) / (y2 - y1 ) != (x3 - x2) / (y3 - y2)  ==> (x2 - x1) * (y3 - y2) != y2 - y1 ) * (x3 - x2)
    public boolean isBoomerang(int[][] points) {
        return (points[0][0] - points[1][0]) * (points[1][1] - points[2][1]) != (points[1][0] - points[2][0]) * (points[0][1] - points[1][1]);
    }
}
