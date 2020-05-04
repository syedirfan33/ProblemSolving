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
	      int maxCount = 0;
	       
	        Map<Integer, Integer> counts = new HashMap<>();
	        int count = 0;
	        for(int i=0;i<nums.length;i++){
	            count += nums[i] == 1 ? 1 : -1;
	            
	            if(count == 0){
	                maxCount = i + 1;
	            }
	            if(counts.containsKey(count)){
	                maxCount = Math.max(maxCount, i - counts.get(count));
	            }else{
	                counts.put(count, i);
	            }
	        }
	        return maxCount;
	    }

}
