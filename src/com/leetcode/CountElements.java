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
public class CountElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] in = {1,3,2,3,5,0};
		System.out.println(countElements(in));
	}

	
	 public static int countElements(int[] arr) {
	       Map<Integer, Integer> ch = new HashMap<>();
	        
	        int res = 0;
	        for(Integer num: arr){
	            if(ch.containsKey(num + 1)){
	                res++;
	            }
	            if(!ch.containsKey(num) && ch.containsKey(num - 1)){
	                res+=ch.get(num - 1);
	            }
	            
	            ch.put(num,  ch.getOrDefault(num, 0) + 1);
	        }
	        ch.forEach((k,v)->System.out.println(k + "" + v));
	        return res;
	    }
	
}
