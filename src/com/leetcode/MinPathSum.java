/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class MinPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int minPathSum(int[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        
	        int rows = grid.length;
	        int columns = grid[0].length;
	        for(int i=0;i<rows;i++){
	            for(int j=0;j<columns;j++){
	                if(i>0 && j>0){
	                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]); 
	                }else if(i > 0){
	                    grid[i][j] += grid[i-1][j];
	                }else if(j > 0 ){
	                    grid[i][j] += grid[i][j-1];
	                }
	            }
	        }
	        return grid[rows-1][columns-1];
	    }

}
