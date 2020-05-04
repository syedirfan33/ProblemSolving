/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class MatrixbinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null || matrix.length == 0) return false;
		 int rows = matrix.length;
		 int columns = matrix[0].length;
		 int left = 0;
		 int right = (rows * columns) -1;
		
		 while(left <= right) {
			 int midpoint = left + (right - left) / 2;
			 int midpoint_element = matrix[midpoint / columns][midpoint%columns];
			 if(target == midpoint_element) return true;
			 else if(target < midpoint_element) right = midpoint - 1;
			 else left = midpoint + 1;
		 }
		 return false;
	 }
}
