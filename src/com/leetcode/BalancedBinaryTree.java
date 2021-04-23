package com.leetcode;

public class BalancedBinaryTree {

    // This problem is same as height balanced binary tree Algo Expert, see method 2 as well
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

    public boolean isBalancedII(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root) != -1;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }
        return Math.max(left, right) + 1;
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
