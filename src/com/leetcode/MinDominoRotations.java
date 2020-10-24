package com.leetcode;

public class MinDominoRotations {

    // Solution 1 : Space : O(1), Time : O(6N + 6N) == O(N)
    public int minDominoRotations(int[] A, int[] B) {
        int res1 = getMinRotations(A, B);
        int res2 = getMinRotations(B, A);
        return res1 == -1 ? res2 : res2 == -1 ? res1 : Math.min(res1, res2);
    }

    private int getMinRotations(int[] A, int[] B) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            int rotations = 0;
            int n = 0;
            for (int j = 0; j < A.length; j++) {
                if (A[j] == i) n++;
                else if (B[j] == i) {
                    rotations++;
                    n++;
                } else break;
            }
            if (n == A.length) res = Math.min(res, rotations);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    // Solution 2 : Space : O(N), Time : O(N)
    public int minDominoRotations2(int[] A, int[] B) {
        int[] totalA = new int[7], totalB = new int[7], common = new int[7];
        for(int i = 0; i < A.length; i++){
            totalA[A[i]]++;
            totalB[B[i]]++;
            if(A[i] == B[i]) common[A[i]]++;
        }
        int res = Integer.MAX_VALUE;

        for(int i = 1; i < totalA.length; i++){
            if(A.length == totalA[i] + totalB[i] - common[i]){
                int rotations = Math.min(totalA[i], totalB[i]) - common[i];
                res = Math.min(res, rotations);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
