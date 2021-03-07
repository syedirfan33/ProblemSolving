/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class SearchInMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public boolean searchMatrix(int[][] matrix, int target) {
		 if(matrix == null || matrix.length == 0) return false;
	        int row = 0;
	        int column = matrix[0].length - 1;
	        while(row < matrix.length && column >=0 ) {
	        	int current = matrix[row][column];
	        	if(matrix[row][column] == target) return true;
	        	if(current > target) column--; // all the other values in current column would definitely be higher
	        	row++;
	        }
	        return false;
	    }

}
