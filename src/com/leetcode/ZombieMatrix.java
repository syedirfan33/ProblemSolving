/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Syed Irfan
 *
 */
public class ZombieMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] inp = {{0, 1, 1, 0, 1},
		               {0, 1, 0, 1, 0},
		               {0, 0, 0, 0, 1},
		               {0, 1, 0, 0, 0}};
		List<Integer> li1 = Arrays.asList(0,1,1,0,1);
		List<Integer> li2 = Arrays.asList(0,1,0,1,0);
		List<Integer> li3 = Arrays.asList(0,0,0,0,1);
		List<Integer> li4 = Arrays.asList(0,1,0,0,0);
		List<List<Integer>> li = new ArrayList<>();
		li.add(li1);li.add(li2);li.add(li3);li.add(li4);
		System.out.println(Arrays.toString(li.toArray()));
		System.out.println(minHours(li));
	}
	
	static int minHours(List<List<Integer>> grid) {
		class Pair{
			int i;
			int j;
			
			Pair(int i, int j){
				this.i = i;
				this.j = j;
			}
			
			/* (non-Javadoc)
			 * @see java.lang.Object#equals(java.lang.Object)
			 */
			@Override
			public boolean equals(Object obj) {
				if(this == obj) return true;
				if(obj == null || getClass() != obj.getClass()) return false;
				Pair pair = (Pair) obj;
				return this.i == pair.i && this.j == pair.j;
			}
			
			@Override
            public int hashCode() {
                return Objects.hash(i, j);
            }
			
		}
		
		Set<Pair> negative = new HashSet<>();
		Set<Pair> positive = new HashSet<>();
		
		for(int i=0;i<grid.size();i++) {
			for (int j=0;j<grid.get(0).size();j++) {
				if(grid.get(i).get(j) == 0) negative.add(new Pair(i,j));
				else positive.add(new Pair(i,j));
			}
		}
		
		int hours = 0;
		int[][] dir = {{0,1}, {1,0}, {-1,0},{0,-1}};
		while(negative.size() > 0) {
			Set<Pair> infected = new HashSet<>();
			for(Pair current : positive) {
				int i = current.i;
				int j = current.j;
				for(int k=0;k<dir.length;k++) {
					int nextI = i + dir[k][0];
					int nextJ = j + dir[k][1];
					if(negative.contains(new Pair(nextI, nextJ))) {
						infected.add(new Pair(nextI, nextJ));
						negative.remove(new Pair(nextI, nextJ));
					}
				}
			}
			
			if(infected.size() == 0) return -1;
			hours+=1;
			positive = infected;
		}
		
		return hours;
		
	}
	
	

}
