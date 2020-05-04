/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class BSTfromPreOT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3305/
	public TreeNode bstFromPreorder(int[] preorder) {

		TreeNode root = new TreeNode(preorder[0]);
		root = setNodes(preorder, 0, preorder.length - 1);
		return root;
	}

	private TreeNode setNodes(int[] preorder, int left, int right) {
		if (left > right)
			return null;
		TreeNode root = new TreeNode(preorder[left]);
		if (left == right)
			return root;

		int index = left + 1;
		while (index <= right && preorder[index] < preorder[left]) {
			index++;
		}

		root.left = setNodes(preorder, left + 1, index - 1);
		root.right = setNodes(preorder, index, right);

		return root;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
