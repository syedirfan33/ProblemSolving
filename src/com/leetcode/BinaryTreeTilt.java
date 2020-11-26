package com.leetcode;

public class BinaryTreeTilt {
    int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        int tilt1 = helper(root.left);
        int tilt2 = helper(root.right);
        int finalRes = Math.abs(tilt1 - tilt2);
        res += finalRes;
        return tilt1 + tilt2 + root.val;
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
