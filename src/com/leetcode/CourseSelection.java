/**
 * 
 */
package com.leetcode;

import java.util.LinkedList;

/**
 * @author Syed Irfan
 *
 */
public class CourseSelection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        int[] inDegree = new int[numCourses];
	        int count = 0;
	        
	        for(int i=0;i<prerequisites.length;i++){
	            inDegree[prerequisites[i][0]]++;
	        }
	        
	        LinkedList<Integer> stack = new LinkedList<>();
	        
	        for(int i=0;i<inDegree.length;i++){
	            if(inDegree[i] == 0) stack.push(i);
	        }
	        
	        while(!stack.isEmpty()){
	            int current = stack.pop();
	            count++;
	            for(int i=0;i<prerequisites.length;i++){
	                if(prerequisites[i][1] == current){
	                    inDegree[prerequisites[i][0]]--;
	                    if(inDegree[prerequisites[i][0]] == 0) stack.push(prerequisites[i][0]);
	                }
	            }
	        }
	        return count == numCourses;
	    }
	 
}
