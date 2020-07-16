package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Syed Irfan - 09/07/2020
 */
public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            int len = nums.length;
            
            for(int first = 0; first < len - 2; first++){
                int left = first + 1;
                int right = len - 1;
                if(first == 0 || nums[first] != nums[first - 1]){
                    while(left < right){
                        int val = nums[first] + nums[left] + nums[right];
                        if(val < 0){
                            left++;
                        }else if(val > 0){
                            right--;
                        }else{
                            set.add(Arrays.asList(nums[first], nums[left], nums[right] ));
                            left++;
                            right--;
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }
    
}
