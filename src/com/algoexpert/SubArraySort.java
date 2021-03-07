package com.algoexpert;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (!isValid(array, i)) {
                min = Math.min(min, array[i]);
                max = Math.max(max, array[i]); // The aim is to find min and max element in the array which is offset
            }
        }
        // If the array is perfectly sorted
        if (min == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        int i;
        for (i = 0; i < array.length; i++) {
            if (array[i] > min) break;
        }
        int j;
        for (j = array.length - 1; j >= 0; j--) {
            if (array[j] < max) break;
        }
        return new int[]{i, j};
    }

    private static boolean isValid(int[] array, int idx) {
        int left = idx == 0 ? Integer.MIN_VALUE : array[idx - 1];
        int right = idx == array.length - 1 ? Integer.MAX_VALUE : array[idx + 1];
        return array[idx] >= left && array[idx] <= right; // It should be perfectly sorted, [ 1 2 3]
    }
}
