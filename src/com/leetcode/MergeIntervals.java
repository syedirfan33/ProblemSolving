/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Syed Irfan
 *
 */
public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inp = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		int[][] inp2 = { {1,5},{3,6},{2,8} };

		System.out.println(Arrays.deepToString(merge(inp2)));
	}

	public static int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if (intervals.length <= 1)
			return intervals;

		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int[] current = intervals[0];
		res.add(current);
		for (int i = 1; i < intervals.length; i++) {
			int cur_start = current[0];
			int cur_end = current[1];
			int next_start = intervals[i][0];
			int next_end = intervals[i][1];
			if (cur_end >= next_start) {
				current[1] = Math.max(cur_end, next_end);
			} else {
				current = intervals[i];
				res.add(current);
				Arrays.asList(123,344);
			}
		}
		return res.toArray(new int[res.size()][]);
	}

}
