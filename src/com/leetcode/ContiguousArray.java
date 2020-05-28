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
public class ContiguousArray {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    //525, for binary array
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, -1);
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 1 ? 1 : -1;
            
            if (countMap.containsKey(count)) {
                maxCount = Math.max(maxCount, i - countMap.get(count));
            } else {
                countMap.put(count, i);
            }
        }
        return maxCount;
    }
    
}
