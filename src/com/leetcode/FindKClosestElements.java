package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Video from coding decoded
        List<Integer> res = new ArrayList<>();
        int left = 0, right = arr.length - 1;
        while (right - left >= k) {
            int diff1 = Math.abs(arr[left] - x);
            int diff2 = Math.abs(arr[right] - x);
            if (diff1 <= diff2)
                right--;
            else
                left++;
        }

        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
