/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class ThreeLargest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int[] findThreeLargest(int[] array) {
		int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
		for(int num: array) {
			updateArray(result, num);
		}
		return result;
	}

	private static void updateArray(int[] result, int num) {
		if(num > result[2]) {
			shiftAndUpdate(result, num, 2);
		}else if(num > result[1]) {
			shiftAndUpdate(result, num, 1);
		}else if(num > result[0]) {
			shiftAndUpdate(result, num, 0);
		}
	}

	private static void shiftAndUpdate(int[] array, int num, int index) {
		for(int i=0;i<index+1;i++) {
			if(i==index) {
				array[i] = num;
			}else {
				array[i] = array[i+1];
			}
		}
	}

}
