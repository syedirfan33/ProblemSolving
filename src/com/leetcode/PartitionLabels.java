/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class PartitionLabels {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

	 public static List<Integer> partitionLabels(String S) {
		 if(S == null || S.trim().length() == 0) return null;
		 List<Integer> result = new ArrayList<Integer>();
		 int[] lastOccurence = new int[26];
		 
		 for(int i=0;i<S.length();i++) {
			 lastOccurence[S.charAt(i) - 'a'] = i; 
		 }
		
		 int i =0;
		 while(i < S.length()) {
			 int end = lastOccurence[S.charAt(i) - 'a'];
			 int j=i;
			 while(j!=end) {
				end = Math.max(end, lastOccurence[S.charAt(j) - 'a']);
				j++;
			 }
			 result.add(j-i+1);
			 i = j+1;
		 }
		 
		 return result;
	        
	    }
	 
}
