package com.leetcode;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Inspired by my half solution, and little help from comments
    TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return res;
    }


    private boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        if (root == p || root == q) {
            boolean foundOther = helper(root.left, p, q);
            if (foundOther) {
                res = root;
            }
            foundOther = helper(root.right, p, q);
            if (foundOther) {
                res = root;
            }
            return true;
        }
        boolean foundFirst = helper(root.left, p, q);
        boolean foundSecond = helper(root.right, p, q);
        if (foundFirst && foundSecond) {
            res = root;
        }
        return foundFirst || foundSecond;
    }
}
