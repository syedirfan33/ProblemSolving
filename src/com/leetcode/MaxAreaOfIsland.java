/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class MaxAreaOfIsland {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,1,1,0,1,0,0,0,0,0,0,0,0},
				 {0,1,0,0,1,1,0,0,1,0,1,0,0},
				 {0,1,0,0,1,1,0,0,1,1,1,0,0},
				 {0,0,0,0,0,0,0,0,0,0,1,0,0},
				 {0,0,0,0,0,0,0,1,1,1,0,0,0},
				 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		int[][] grid2 = {{0,1,1},{0,1,0},{0,1,0}};
		maxAreaOfIsland(grid);
	}
	
	 public static int maxAreaOfIsland(int[][] grid) {
		 int maxArea = 0;
			for(int i=0;i<grid.length;i++) {
				for(int j=0;j<grid[i].length;j++) {
					
					if(grid[i][j] == 1) {
						int temp = dfs(grid, i, j, 0);
						maxArea = Math.max(temp, maxArea);
					}
					
				}
			}
			return maxArea;
	    }

	private static int dfs(int[][] grid, int i, int j, int currentArea) {
		//System.out.println(maxArea);

		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0) {
			return currentArea;
		}
		
		grid[i][j] = 0;
		currentArea++;
		currentArea = dfs(grid, i+1, j, currentArea);
		currentArea = dfs(grid, i, j+1, currentArea);
		currentArea = dfs(grid, i-1, j, currentArea);
		currentArea = dfs(grid, i, j-1, currentArea);
		
		return currentArea;
	}

}
