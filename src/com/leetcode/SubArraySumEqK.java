/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class SubArraySumEqK {
	   public int subarraySum(int[] nums, int k) {
	        int res = 0;
	        int sum = 0;
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);
	        for(int num: nums){
	            sum += num;
	            
	            if(map.containsKey(sum - k)){
	                res += map.get(sum - k);
	            }
	            
	            map.put(sum, map.getOrDefault(sum, 0) + 1);
	        }
	        return res;
	    }
}
