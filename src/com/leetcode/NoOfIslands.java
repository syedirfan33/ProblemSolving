/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class NoOfIslands {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] grid = {{'1','1'}, {'1','1'}};
			System.out.println();
	}
	
	 public int numIslands(char[][] grid) {
	        int noIslands = 0;
	        for(int i=0;i<grid.length;i++){
	            for(int j=0;j<grid[i].length;j++){
	                if(grid[i][j] == '1'){
	                    noIslands++;
	                    dfs(grid, i, j);
	                }
	            }
	        }
	        return noIslands;
	    }
	    
	    void dfs(char[][] grid, int i, int j){
	        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0'){
	            return;
	        }
	        grid[i][j] = '0';
	        dfs(grid, i+1, j);
	        dfs(grid, i, j+1);
	        dfs(grid, i-1, j);
	        dfs(grid, i, j-1);
	    }
}
