package com.leetcode;

import java.util.Arrays;

public class Candy {
    // video from coding decoded
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] arr = new int[len];
        Arrays.fill(arr, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        int res = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && arr[i] <= arr[i + 1]) {
                arr[i] = arr[i + 1] + 1;
            }
            res += arr[i];
        }
        return res;
    }
}
