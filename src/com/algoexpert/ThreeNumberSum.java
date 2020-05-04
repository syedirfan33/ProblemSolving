/**
 * 
 */
package com.algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class ThreeNumberSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Integer[]> res = getThreeNumSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
		 res.stream().forEach(action->{
			 System.out.println(Arrays.toString(action));
		 });
	}

	public static List<Integer[]> getThreeNumSum(int[] input, int targetSum) {
		Arrays.sort(input);
		
		List<Integer[]> res = new ArrayList<Integer[]>();
		for (int i = 0; i < input.length-2; i++) {
			int left = i+1;
			int right = input.length -1;
			while( left<right) {
				int sum = input[i] + input[left] + input[right];
				if (sum == targetSum) {
					res.add(new Integer[] { input[i], input[left], input[right] });
					left++;
					right--;
				} else if (sum < targetSum) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}
}
