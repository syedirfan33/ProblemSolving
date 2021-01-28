package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiskStakking {

    // This is typical dynamic prog. problem. I have made slight change to algo exp solution. If you visualise this prob , its pretty easy
    public static List<Integer[]> diskStacking(List<Integer[]> disks) {
        if (disks.size() <= 1) return disks;
        List<Integer[]> res = new ArrayList<>();
        int[] indexes = new int[disks.size()];
        int[] heights = new int[disks.size()];
        int maxHeight = 0, maxIdx = -1;
        disks.sort((a, b) -> Integer.compare(a[2], b[2]));
        for (int i = 0; i < disks.size(); i++) {
            indexes[i] = -1;
            int curHeight = disks.get(i)[2];
            heights[i] = curHeight;
            for (int j = 0; j < i; j++) {
                if (isValid(disks.get(j), disks.get(i))) {
                    if (heights[j] + curHeight > heights[i]) {
                        heights[i] = heights[j] + curHeight;
                        indexes[i] = j;
                    }
                }
            }
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                maxIdx = i;
            }
        }
        System.out.println(Arrays.toString(indexes));
        System.out.println(Arrays.toString(heights));
        System.out.println(maxIdx);
        return buildRes(indexes, maxIdx, disks);
    }

    private static List<Integer[]> buildRes(int[] indexes, int maxIdx, List<Integer[]> disks) {
        List<Integer[]> res = new ArrayList<>();
        res.add(disks.get(maxIdx));
        while (indexes[maxIdx] != -1) {
            res.add(0, disks.get(indexes[maxIdx]));
            maxIdx = indexes[maxIdx];
        }
        return res;
    }

    private static boolean isValid(Integer[] first, Integer[] second) {
        return first[0] < second[0] && first[1] < second[1] && first[2] < second[2];
    }
}
