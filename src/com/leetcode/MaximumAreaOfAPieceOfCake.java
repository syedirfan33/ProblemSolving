package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 04/06/2020
 */
public class MaximumAreaOfAPieceOfCake {
    
    // We can use helper function to get res 1 and res2(same logic)
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int vDiff = Integer.MIN_VALUE;
        for(int i = 0; i < verticalCuts.length - 1; i++){
            vDiff = Math.max(vDiff, verticalCuts[i + 1] - verticalCuts[i]);
        }
        int hDiff =  Integer.MIN_VALUE;
        for(int i = 0; i < horizontalCuts.length - 1; i++){
            hDiff = Math.max(hDiff, horizontalCuts[i + 1] - horizontalCuts[i]);
        }
        int res1 = Math.max(hDiff, Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]));
        int res2 = Math.max(vDiff, Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]));
        int mod = 1000000007;
        long ans = (((long)res1%mod)*((long)res2%mod))%mod;
        return (int)ans;
    }
    
}
