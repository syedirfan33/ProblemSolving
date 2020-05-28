package com.leetcode;

import sun.nio.cs.ext.SJIS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan - 23/05/2020
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        getPermutations(0, nums, res);
        return res;
    }

    private void getPermutations(int i, int[] nums, List<List<Integer>> res) {
        if (i == nums.length - 1) {
            List<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            res.add(cur);
        } else {
            for (int j = i; j < nums.length; j++) {
                swap(i, j, nums);
                getPermutations(i + 1, nums, res);
                swap(i, j, nums);
            }
        }

    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
