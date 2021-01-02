package com.leetcode;

public class LongestTurbulentSubArray {

    // My solution ,had to handle a lot of corner cases
    public int maxTurbulenceSize(int[] A) {
        if(A.length == 1) return 1;
        int res = 1, cur = 2;
        int i = 0;
        while(i < A.length - 1 && A[i] == A[i + 1]) i++;
        if(i >= A.length - 1) return 1;
        boolean increase = A[i] > A[i + 1] ? false : true;
        int left = i + 1;
        while(left < A.length - 1){
            if(increase){
                if(A[left] > A[left + 1]){
                    increase = false;
                    cur++;
                }else{
                    res = Math.max(cur, res);
                    if(A[left] == A[left + 1]) cur = 1;
                    else cur = 2;
                }
            }else{
                if(A[left] < A[left + 1]){
                    increase = true;
                    cur++;
                }else{
                    res = Math.max(cur, res);
                    if(A[left] == A[left + 1]) cur = 1;
                    else cur = 2;                }
            }
            left++;
        }
        return Math.max(res, cur);
    }

    // A better solution. can be considered as DP
    public int maxTurbulenceSizeII(int[] A) {
        int inc = 1, dec = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]) {
                dec = inc + 1;
                inc = 1;
            } else if (A[i] > A[i - 1]) {
                inc = dec + 1;
                dec = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            result = Math.max(result, Math.max(dec, inc));
        }
        return result;
    }
}
