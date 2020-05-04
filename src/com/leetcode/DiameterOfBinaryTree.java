/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class DiameterOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int l_h = height(root.left);
		int r_h = height(root.right);

		int l_d = diameterOfBinaryTree(root.left);
		int r_d = diameterOfBinaryTree(root.right);

		return Math.max(l_h + r_h, Math.max(l_d, r_d));
	}

	private static int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
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
