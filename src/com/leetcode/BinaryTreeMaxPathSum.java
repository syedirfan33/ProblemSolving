package com.leetcode;

public class BinaryTreeMaxPathSum {

    // video from tech dose
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        int case1 = Math.max(Math.max(left, right) + root.val, root.val);
        int case2 = left + right + root.val;

        res = Math.max(res, Math.max(case1, case2));

        return case1;
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
