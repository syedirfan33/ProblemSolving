package com.leetcode;

public class InsertIntoBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode node = new TreeNode(val);
            return node;
        }
        helper(root, val);
        return root;
    }

    private void helper(TreeNode node, int val) {
        if (node.val < val && node.right == null) {
            TreeNode newNode = new TreeNode(val);
            node.right = newNode;
            return;
        } else if (node.val > val && node.left == null) {
            TreeNode newNode = new TreeNode(val);
            node.left = newNode;
            return;
        } else if (node.val < val) {
            helper(node.right, val);
        } else {
            helper(node.left, val);
        }
    }

    public TreeNode insertIntoBSTIterative(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode cur = root;
        while (true) {
            if (cur.val < val) {
                if (cur.right == null) {
                    TreeNode newNode = new TreeNode(val);
                    cur.right = newNode;
                    break;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.left == null) {
                    TreeNode newNode = new TreeNode(val);
                    cur.left = newNode;
                    break;
                } else {
                    cur = cur.left;
                }
            }
        }
        return root;
    }
}
