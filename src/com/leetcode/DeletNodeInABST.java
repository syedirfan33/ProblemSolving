package com.leetcode;

public class DeletNodeInABST {
    // Solution inspired by me , with help of Naresh Gupta's video
    public TreeNode deleteNode(TreeNode root, int key) {
        return findAndUpdate(root, key);
    }

    private TreeNode findAndUpdate(TreeNode node, int key) {
        if (node == null)
            return node;

        if (node.val == key) {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                int newVal = findLeftMost(node.right);
                node.val = newVal;
                node.right = findAndUpdate(node.right, newVal);
            }

        } else if (node.val > key) {
            node.left = findAndUpdate(node.left, key);
        } else {
            node.right = findAndUpdate(node.right, key);
        }
        return node;
    }

    private int findLeftMost(TreeNode node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node.val;
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
