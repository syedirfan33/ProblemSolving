package com.leetcode;

import java.util.Arrays;

public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;
        for(int[] box: boxTypes){
            if(truckSize == 0)
                break;
            if(box[0] >= truckSize){
                truckSize -= box[0];
                res += box[0] * box[1];
            }else{
                res += truckSize * box[1];
                break;
            }
        }
        return res;
    }
}
