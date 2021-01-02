package com.leetcode;

public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        char[] arr = (n + "").toCharArray();
        int i = arr.length - 1;
        while (i > 0) {
            if (arr[i] > arr[i - 1]) break;
            i--;
        }
        if (i == 0) return -1;
        int firstDefPoint = i - 1;
        int otherDefPoint = arr.length - 1;
        while (otherDefPoint > firstDefPoint) {
            if (arr[otherDefPoint] > arr[firstDefPoint]) break;
            otherDefPoint--;
        }

        swap(firstDefPoint, otherDefPoint, arr);
        reverse(firstDefPoint + 1, arr);
        long res = Long.parseLong(new String(arr));
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;

    }

    private void reverse(int left, char[] arr) {
        int right = arr.length - 1;
        while (left < right) {
            swap(left++, right--, arr);
        }
    }

    private void swap(int left, int right, char[] arr) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
