package com.leetcode;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            flipAndInvert(A, i);
        }
        return A;
    }

    private void flipAndInvert(int[][] A, int row) {
        int left = 0, right = A[0].length - 1;
        while (left <= right) {
            int temp = A[row][left];
            A[row][left] = A[row][right] == 1 ? 0 : 1;
            A[row][right] = temp == 1 ? 0 : 1;
            left++;
            right--;
        }
    }
}
