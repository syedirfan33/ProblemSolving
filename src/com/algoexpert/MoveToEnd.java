/**
 * 
 */
package com.algoexpert;

import java.util.Arrays;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class MoveToEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println(Arrays.toString(moveElementsToEnd(new int[]
		// {2,1,2,2,2,3,4,2},2)));
	}

	// 4,1,2,3,4,3,2,2
	public static List<Integer> moveElementsToEnd(List<Integer> arr, int num) {
		int i = 0;
		int j = arr.size() - 1;
		while (i < j) {
			if (arr.get(j) == num) {
				j--;
			} else {
				swap(arr, i, j);
				i++;
			}
		}
		return arr;
	}

	private static void swap(List<Integer> arr, int i, int j) {
		int temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}

}
