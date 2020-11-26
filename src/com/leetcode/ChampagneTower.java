package com.leetcode;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[101][101];
        tower[0][0] = poured;
        for (int row = 0; row < query_row; row++) {
            for (int glass = 0; glass <= row; glass++) {
                double overflow = tower[row][glass] - 1.0;
                double divident = overflow / 2.0; //divide into two parts for the next two glasses;
                if (divident > 0) {
                    tower[row + 1][glass] += divident;
                    tower[row + 1][glass + 1] += divident;
                }
            }
        }
        return Math.min(1.0, tower[query_row][query_glass]);
    }
}
