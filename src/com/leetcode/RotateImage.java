package com.leetcode;

public class RotateImage {
    //Video from Algos made easy
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int layers = len / 2;
        for (int layer = 0; layer < layers; layer++) {
            int start = layer;
            int end = len - start - 1;
            for (int i = start; i < end; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[len - 1 - i][start];
                matrix[len - 1 - i][start] = matrix[end][len - 1 - i];
                matrix[end][len - 1 - i] = matrix[i][end];
                matrix[i][end] = temp;
            }
        }
    }
}
