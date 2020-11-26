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
                if(nums[first] > 0) break;
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

        // Without using set, a bit faster too
        public List<List<Integer>> threeSumII(int[] num) {
            Arrays.sort(num);
            List<List<Integer>> res = new LinkedList<>();
            for (int i = 0; i < num.length-2; i++) {
                if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                    int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                    while (lo < hi) {
                        if (num[lo] + num[hi] == sum) {
                            res.add(Arrays.asList(num[i], num[lo], num[hi]));
                            while (lo < hi && num[lo] == num[lo+1]) lo++;
                            while (lo < hi && num[hi] == num[hi-1]) hi--;
                            lo++; hi--;
                        } else if (num[lo] + num[hi] < sum) lo++;
                        else hi--;
                    }
                }
            }
            return res;
        }
}
