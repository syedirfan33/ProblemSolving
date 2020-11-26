package com.leetcode;

public class RecoverBinarySearchTree {

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

    TreeNode firstStartPoint = null, lastEndPoint = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = firstStartPoint.val;
        firstStartPoint.val = lastEndPoint.val;
        lastEndPoint.val = temp;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev.val > root.val) {
            if (firstStartPoint == null) {
                firstStartPoint = prev;
            }
            lastEndPoint = root;
        }
        prev = root;
        helper(root.right);
    }
}
