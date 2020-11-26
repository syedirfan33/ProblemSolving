package com.leetcode;

public class MaximumDifferenceBetweenNodeAndAncestor {
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

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int minVal, int maxVal) {
        if (root == null) return maxVal - minVal;
        minVal = Math.min(minVal, root.val);
        maxVal = Math.max(maxVal, root.val);
        int leftAbs = dfs(root.left, minVal, maxVal);
        int rightAbs = dfs(root.right, minVal, maxVal);
        return Math.max(leftAbs, rightAbs);
    }
}
