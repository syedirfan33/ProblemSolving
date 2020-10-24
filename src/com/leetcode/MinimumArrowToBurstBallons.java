package com.leetcode;

import java.util.Arrays;

public class MinimumArrowToBurstBallons {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1] , b[1]));
        int[] current = points[0];
        int res = 1;
        for(int i = 1; i < points.length; i++){
            if(current[1] < points[i][0]){
                res++;
                current = points[i];
            }
        }
        return res;
    }
}
