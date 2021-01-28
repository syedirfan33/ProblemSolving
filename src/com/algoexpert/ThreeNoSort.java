package com.algoexpert;

public class ThreeNoSort {
    public int[] threeNumberSort(int[] array, int[] order) {
        int firstIdx = 0;
        int lastIdx = array.length - 1;
        int i = 0;
        while (i <= lastIdx) {
            if (array[i] == order[0]) {
                swap(i, firstIdx, array);
                firstIdx++;
                i++;
            } else if (array[i] == order[2]) {
                swap(i, lastIdx, array);
                lastIdx--;
            } else {
                i++;
            }
        }
        return array;
    }

    private void swap(int first, int second, int[] arr) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
