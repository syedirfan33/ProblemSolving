package com.leetcode;

/**
 * @author Syed Irfan - 21/05/2020
 */
public class KthSmallestInBST {

    // Or can simply store inorder traversal in ArrayList and return list.get(k - 1);
    public static int kThSmallest(CompleteBinaryTree.TreeNode root, int k) {
        int[] nums = new int[2];
        inOrder(root, nums, k);
        return nums[1];
    }

    private static void inOrder(CompleteBinaryTree.TreeNode root, int[] nums, int k) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums, k);
        nums[0]++;
        if (nums[0] == k) {
            nums[1] = root.val;
            return;
        }
        inOrder(root.right, nums, k);
    }

}
