/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class Kadane {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maximumSubArraySum(int[] array) {
		int maxNum = array[0];
		int maxAtIndex = array[0];
		for(int i=1;i<array.length;i++) {
			maxAtIndex = Math.max(maxAtIndex + array[i], array[i]);
			maxNum = Math.max(maxNum, maxAtIndex);
		}
		return maxNum;
	}
}
