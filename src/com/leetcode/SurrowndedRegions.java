/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class SurrowndedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void solve(char[][] board) {
	     for(int i=1;i<board.length-1;i++) {
	    	 for(int j=1;j<board[i].length-1;j++) {
	    		 if(board[i][j] == '0') {
	    		 surrownd(board, i, j);
	    		 }
	    	 }
	     }
	 }
	 
	 void surrownd(char[][] grid, int i, int j) {
		 if(grid[i+1][j] == 'X' || grid[i][j+1] == 'X' || grid[i-1][j] == 'X' || grid[i][j-1] == 'X') {
			 grid[i][j] = 'X';
		 }
	 }

}
