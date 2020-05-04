/**
 * 
 */
package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class ProductSum {
	public static int productSum(List<Object> array) {
		return productSumHelper(array, 1);
	}

	private static int productSumHelper(List<Object> array, int multiplier) {
		int sum = 0;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) instanceof ArrayList) {
				sum = sum + productSumHelper(array, multiplier + 1);
			} else {
				sum = sum + (int) array.get(i);
			}
		}
		return sum * multiplier;
	}
}
