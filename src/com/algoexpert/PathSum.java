/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		else if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		else {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}

	public class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
