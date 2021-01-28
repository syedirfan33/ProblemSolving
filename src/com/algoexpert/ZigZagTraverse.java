package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ZigZagTraverse {
    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> res = new ArrayList<>();
        boolean goingDown = true;
        int height = array.size();
        int width = array.get(0).size();
        int row = 0;
        int column = 0;
        while (res.size() < width * height) {
            res.add(array.get(row).get(column));
            if (goingDown) {
                if (column == 0 || row == height - 1) {
                    goingDown = false;
                    if (row == height - 1) column++;
                    else row++;
                } else {
                    row++;
                    column--;
                }
            } else {
                if (row == 0 || column == width - 1) {
                    goingDown = true;
                    if (column == width - 1) row++;
                    else column++;
                } else {
                    row--;
                    column++;
                }
            }
        }
        return res;
    }
}
