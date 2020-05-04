/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class IslandPerimeter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int cur = grid[i][j];
                if(grid[i][j] == 1){
                int res = dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1);
                if(res == 1) perimeter +=3;
                else if(res == 2) perimeter +=2;
                else if(res == 3) perimeter +=1;
                    else if(res == 0) perimeter +=4;
                }
            }
        }
        return perimeter;
    }
    
    private int dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0){
            return 0; 
        }
        return 1; 
    }

}
