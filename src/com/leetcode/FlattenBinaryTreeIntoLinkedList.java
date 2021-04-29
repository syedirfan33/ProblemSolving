package com.leetcode;

public class FlattenBinaryTreeIntoLinkedList {
    // Answer from discuss section
    public void flatten(TreeNode root) {
        preOrder(root);
    }

    private void preOrder(TreeNode root) {
        if (root == null)
            return;
        preOrder(root.left);
        preOrder(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = left;
        while (root.right != null) {
            root = root.right;
        }
        root.right = right;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
