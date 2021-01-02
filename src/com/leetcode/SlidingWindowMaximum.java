package com.leetcode;

import java.util.TreeMap;

public class SlidingWindowMaximum {
    // O(nk) solution, got TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i + k <= nums.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < k; j++) {
                max = Math.max(max, nums[i + j]);
            }
            res[i] = max;
        }
        return res;
    }

    // O(nlogk) solution, accepted. But this could further be optimised to O(n)
    public int[] maxSlidingWindowII(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for(int i = 0; i < len; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(i >= k - 1){ // This is where we need to start populating res array
                res[j++] = map.lastKey();
                // Now for the next iteration, we have to remove the first element of previous start of slide
                int firstElement = nums[i - k + 1];
                if(map.get(firstElement) > 1){
                    map.put(firstElement, map.get(firstElement) - 1);
                }else{
                    map.remove(firstElement);
                }
            }
        }
        return res;
    }
}
