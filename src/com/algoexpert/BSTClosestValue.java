/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class BSTClosestValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findClosestValueInBst(BST tree, int target) {
		return findClosestValueInBst(tree, target, Double.MAX_VALUE);
	}

	private static int findClosestValueInBst(BST tree, int target, double closest) {
		if (tree == null)
			return (int)closest;

		if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
			closest = tree.value;
		}
		if (target > Math.abs(tree.value)) {
			return findClosestValueInBst(tree.right, target, closest);
		} else if (target < Math.abs(tree.value)) {
			return findClosestValueInBst(tree.left, target, closest);
		}
		return (int)closest;
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
		}
	}

}
