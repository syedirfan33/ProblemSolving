/**
 * 
 */
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Syed Irfan
 *
 */
public class MaxLevelSumBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxLevelSum(TreeNode root) {

		int max_level = 1;
		int max_sum = Integer.MIN_VALUE;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int level = 0;
		while (!queue.isEmpty()) {
			int cur_sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				cur_sum += cur.val;
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
			level++;
			if (cur_sum > max_sum) {
				max_sum = cur_sum;
				max_level = level;
			}
		}
		return max_level;
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
