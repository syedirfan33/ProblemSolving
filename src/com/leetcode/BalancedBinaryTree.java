package com.leetcode;

public class BalancedBinaryTree {
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private int helper(TreeNode root, int cur) {
        if (root == null) return cur;
        int leftH = helper(root.left, cur + 1);
        int rightH = helper(root.right, cur + 1);
        if (Math.abs(leftH - rightH) > 1) {
            res = false;
            return 0;
        }
        return Math.max(leftH, rightH);
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
