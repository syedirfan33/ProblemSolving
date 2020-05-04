/**
 * 
 */
package com.algoexpert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan
 *
 */
public class BranchSum {
	
	public static class BinaryTree{
		int value;
		BinaryTree left;
		BinaryTree right;
		
		BinaryTree(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static List<Integer> branchSums(BinaryTree root){
		List<Integer> sums = new ArrayList<Integer>();
		calculateSum(root, 0, sums);
		return sums;
	}

	
	private static void calculateSum(BinaryTree root, int runningSum, List<Integer> sums) {
		if(root == null) return;
		
		int newRunningSum = root.value + runningSum;
		
		if(root.left == null && root.right == null) {
			sums.add(newRunningSum);
			return;
		}
		
		calculateSum(root.left, newRunningSum, sums);
		calculateSum(root.right, newRunningSum, sums);

		
	}

}
