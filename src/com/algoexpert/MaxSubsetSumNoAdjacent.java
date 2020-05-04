/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class MaxSubsetSumNoAdjacent {

	/**
	 * @param args
	 */
	public static int maxSubsetSumNoAdjacent(int[] array) {
		if(array.length<=0) {
			return 0;
		}
		if(array.length ==1) {
			return array[0];
		}
	    int[] maxSum = array.clone();
	    maxSum[1] = Math.max(array[0], array[1]);
	    for(int i=2;i<array.length;i++) {
	    	maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + maxSum[i]);
	    }
	    return maxSum[maxSum.length-1];
	  }

}
