/**
 * 
 */
package com.algoexpert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Syed Irfan
 *
 */

//Another Approach to make use of HashMap
public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 10,0};
		System.out.println(Arrays.toString(twoNumberSum(arr, 10)));
		
		
	}

	public static int[] twoNumberSum(int[] array, int targetSum) {
		int[] result = new int[2];
		int[] emptyArr = {};
		Integer[] boxedArray = Arrays.stream(array).boxed().toArray(Integer[]::new);
		Set<Integer> s = new HashSet<Integer>(Arrays.asList(boxedArray));

		Iterator<Integer> it = s.iterator();
		while (it.hasNext()) {
			int curVal = it.next();
			if (curVal <= targetSum) {
				int val = targetSum - curVal;
				if (s.contains(val)) { // Time complexity for HashSet contains method is O(1), but for TreeSet it is O(log(n)
					result[0] = curVal;
					result[1] = val;
					return result;
				}
			}
		}

		return emptyArr;
	}
}
