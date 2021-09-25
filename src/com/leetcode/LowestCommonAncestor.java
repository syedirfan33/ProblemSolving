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


    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || p == node || q == node)
            return node;

        TreeNode firstMatch = helper(node.left, p, q);
        TreeNode secondMatch = helper(node.right, p, q);

        if (firstMatch != null && secondMatch != null)
            return node;
        else if (firstMatch != null)
            return firstMatch;
        else
            return secondMatch;
    }
}

