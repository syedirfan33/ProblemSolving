/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class MinEdit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Very similar to longest common subseq, delete operations of 2 strings
	public static int levenshteinDistance(String str1, String str2) {
		int[][] edits = new int[str1.length()+1][str2.length()+1];
		for(int i=0;i<str1.length()+1;i++) {
			for(int j=0;j<str2.length()+1;j++) {
				edits[0][j] = j;
			}
			edits[i][0] = i;
		}
		
		for(int i=1;i<str1.length()+1;i++) {
			for(int j=1;j<str2.length();j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					edits[i][j] = edits[i-1][j-1];
				}else {
					edits[i][j] = 1 + Math.min(edits[i-1][j-1], Math.min(edits[i-1][j], edits[i][j-1]));
				}
			}
		}
		return edits[str1.length()][str2.length()];
	}

}
