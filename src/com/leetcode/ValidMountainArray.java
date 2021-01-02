package com.leetcode;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        int i = 1;
        int len = arr.length;
        if (len <= 2) return false;
        while (i < len && arr[i] > arr[i - 1]) i++;
        if (i == 1 || i == len) return false;
        while (i < len && arr[i] < arr[i - 1]) i++;
        return i >= len;
    }
}
