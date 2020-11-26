package com.leetcode;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int total = 0;
        for (int num : A) {
            total += num;
        }
        if (total % 3 != 0) return false;
        int magicNo = total / 3;
        int count = 0, sum = 0;
        for (int num : A) {
            sum += num;
            if (sum == magicNo) {
                sum = 0;
                count++;
            }
        }
        return count >= 3;
    }
}
