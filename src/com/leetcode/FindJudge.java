/**
 * 
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class FindJudge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findJudge(2, new int[][] {{1,2}}));
	}

	 public static int findJudge(int N, int[][] trust) {
	        int[] indegree = new int[N+1];
	        if(N == 1) return 1;

	        int max = -1;
	        for(int[] pair: trust){
	            indegree[pair[1]]++;
	            if(  indegree[pair[1]] == N-1) max = pair[1];
	        }
	        
	        for(int[] pair: trust){
	            if(pair[0] == max) return -1;
	        }
	        return max;
	    }
	 
}
