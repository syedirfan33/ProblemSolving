/**
 * 
 */
package com.leetcode;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Syed Irfan
 *
 */
public class RottenOranges {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orangesRotting(int[][] grid) {
		
		
		//For simplicity, do it in Set<String>
		class Pair{
			public final int i;
            public final int j;
            
            Pair(int i, int j){
            	this.i = i;
            	this.j = j;
            }
         
            @Override
            public boolean equals(Object obj) {
            	if(obj == this) return true;
            	if(obj == null || getClass() != obj.getClass()) return false;
            	Pair pair = (Pair) obj;
            	return pair.i == i && pair.j == j;
            }
			
            @Override
            public int hashCode() {
                return Objects.hash(i, j);
            }
		}
		Set<Pair> rotten = new HashSet<>();
	 	Set<Pair> fresh = new HashSet<>();
	 	
	 	for(int i = 0;i < grid.length; i++) {
	 		for(int j = 0; j < grid[0].length; j++) {
	 			int current = grid[i][j];
	 			if(current == 1) fresh.add(new Pair( i , j) );
	 			else if(current == 2) rotten.add(new Pair ( i , j));
	 		}
	 	}
	 	
	 	int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
	 	int minutes = 0;
	 	
	 	while(fresh.size() > 0) {
	 		Set<Pair> infected = new HashSet<>();
	 		for(Pair r: rotten) {
	 			int i = r.i;
	 			int j = r.j;
	 			for(int[] dir: directions) {
	 				int nextI = dir[0] + i;
	 				int nextJ = dir[1] + j;
	 				Pair next = new Pair(nextI, nextJ);
	 				if(fresh.contains(next)) {
	 					infected.add(next);
	 					fresh.remove(next);
	 				}
	 			}
	 		}
	 		
	 		if(infected.size() == 0) return -1;
	 		minutes++;
	 		rotten = infected;
	 	}
	 	return minutes;
	}
	
}
