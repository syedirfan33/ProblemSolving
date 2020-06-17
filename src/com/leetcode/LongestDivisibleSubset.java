package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 15/06/2020
 */
public class LongestDivisibleSubset {
    //space optimised solution
    // Check leet code submission for normal solution which is not space optimized
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int maxSize = 0;
        int maxIdx = -1;
        int n = nums.length;
        int[] links = new int[n];
        int[] sizes = new int[n];
        Arrays.sort(nums);
        for (int i = n - 1; i >= 0; i--) {
            int _maxSize = 0;
            int _maxIdx = i;
            links[i] = -1;
            sizes[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0 && sizes[j] > _maxSize) {
                    _maxIdx = j;
                    _maxSize = sizes[j];
                }
            }
            if (_maxIdx != i) {
                links[i] = _maxIdx;
                sizes[i] += _maxSize;
            }
            if (sizes[i] > maxSize) {
                maxSize = sizes[i];
                maxIdx = i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        while (maxIdx != -1) {
            res.add(nums[maxIdx]);
            maxIdx = links[maxIdx];
        }
        return res;
    }
}