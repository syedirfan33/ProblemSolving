package com.algoexpert;

public class FirstDuplicateValue {
    public int firstDuplicateValue(int[] arr) {
        if (arr.length == 0) return -1;
        for (int i = 0; i < arr.length; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) return idx + 1;
            arr[idx] = -arr[idx];
        }
        return -1;
    }
}
