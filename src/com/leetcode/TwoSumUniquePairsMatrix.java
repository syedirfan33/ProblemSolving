/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class TwoSumUniquePairsMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		int target = 9;
		System.out.println(getPairs(matrix, target));
	}

	public static List<List<Integer>> getPairs(int[][] matrix, int target) {
		int rows = matrix.length;
		int columns = matrix[0].length;
		List<List<Integer>> pairs = new ArrayList<>();
		Map<Integer, Integer> intMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int current = matrix[i][j];
				if (current < target) {
					int diff = target - current;
					if (intMap.containsKey(diff)) {
						if (! intMap.containsKey(current)) {
							List<Integer> pair = new ArrayList<>();
							
							pair.add(diff);
							pair.add(current);
							pairs.add(pair);
							intMap.put(current, diff);
						}
					} else {
						intMap.put(current, diff);
					}
				}
			}
		}
		return pairs;
	}

}
