package com.leetcode;

import java.util.Arrays;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p={p1,p2,p3,p4};
        Arrays.sort(p, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] first = p[0];
        int[] second = p[1];
        int[] third = p[2];
        int[] fourth = p[3]; // This will be diagonal
        double oneTwo = getDist(first, second);
        double twoFour = getDist(second, fourth);
        double threeFour = getDist(third, fourth);
        double oneThree = getDist(third, first);
        double diagOne = getDist(first, fourth);
        double diagTwo = getDist(third, second);
        return oneTwo != 0 && threeFour != 0 && oneTwo == twoFour && threeFour == oneThree && oneTwo == oneThree && diagOne == diagTwo;
    }

    private double getDist(int[] p1, int[] p2){
       return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
}
