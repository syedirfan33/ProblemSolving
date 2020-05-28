package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan - 24/05/2020
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        getUniquePermutations(nums, res, 0);
        return res;
    }
    
    private void getUniquePermutations(int[] nums, List<List<Integer>> res, int i){
        if(i == nums.length){
            List<Integer> curPermutation = new ArrayList<>();
            for(int num : nums){
                curPermutation.add(num);
            }
            res.add(curPermutation);
            return;
        }
        
        Set<Integer> set = new HashSet<>(); // to remove duplicates
        
        for(int j = i; j<nums.length;j++){
            if(set.add(nums[j])){
                swap(nums, i, j);
                getUniquePermutations(nums, res, i+1);
                swap(nums,  i,  j);
            }
        }
    }
    
    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}