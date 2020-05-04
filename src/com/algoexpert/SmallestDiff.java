/**
 * 
 */
package com.algoexpert;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class SmallestDiff {
	
	public static void main(String[] args) {
		int[] arr1 = {-1, 5, 10, 20, 28, 3};
		int[] arr2 = {26, 134, 135, 15, 17};
		int[] res = getSmallest(arr1, arr2);
		System.out.println(Arrays.toString(res));
	}
	
	public static int[] getSmallest(int[] arrOne, int[] arrTwo) {
		Arrays.sort(arrOne);
		Arrays.sort(arrTwo);
		int in1 = 0;
		int in2 = 0;
		int minSum = Integer.MAX_VALUE;
		int curSum = Integer.MIN_VALUE;
		int[] minArr = new int[2];
		while(in1 < arrOne.length && in2 < arrTwo.length) {
			curSum = Math.abs(arrOne[in1] -  arrTwo[in2]);
			if(curSum < minSum) {
				minSum = curSum;
				minArr[0] = arrOne[in1];
				minArr[1] = arrTwo[in2];
			}
			
			if(arrOne[in1] < arrTwo[in2]) {
				in1++;
			}else if (arrOne[in1] > arrTwo[in2]){
				in2++;
			}else {
				return new int[] {arrOne[in1], arrTwo[in2]};
			}
		}
		return minArr;
	}
}
