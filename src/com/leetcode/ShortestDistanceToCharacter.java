package com.leetcode;

public class ShortestDistanceToCharacter {

    //Initially I solved it in 3 pass, but reduced to 2 pass just by small easy tweak
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(S.charAt(i) == C) left[i] = i;
            else if(i != 0 && left[i - 1] != Integer.MAX_VALUE)  left[i] = left[i - 1];
            else left[i] = Integer.MAX_VALUE;
        }
        int[] right = new int[n];
        int res[] = new int[n];
        for(int j = n - 1; j >=0; j--){
            if(S.charAt(j) == C) right[j] = j;
            else if(j != n - 1 && right[j + 1] != Integer.MAX_VALUE) right[j] = right[j + 1];
            else right[j] = Integer.MAX_VALUE;
            // Can modify directly here
            res[j] = Math.min(Math.abs(j - left[j]), Math.abs(j- right[j]));
        }
        return res;
    }
}
