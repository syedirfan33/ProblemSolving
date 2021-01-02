package com.leetcode;

import java.util.PriorityQueue;

public class TrimABST {

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


    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return null;
        return helper(root, low, high);
    }

    // I solved like below, but I was foolish. Can be further reduced.
    private TreeNode helper(TreeNode root, int low, int high){
        if(root == null) return null;
        if(root.val < low) return helper(root.right, low, high);
        if(root.val > high) return helper(root.left, low, high);
        if(root.left != null && root.left.val < low){
            root.left = root.left.right;
            return helper(root, low, high);
        }
        if(root.right != null && root.right.val > high){
            root.right = root.right.left;
            return helper(root, low, high);
        }
        helper(root.left, low, high);
        helper(root.right, low, high);
        return root;
    }

    // Erghhhhhh...
    private TreeNode helperII(TreeNode root, int low, int high) {
        if (root == null) return null;
        if (root.val < low) return helper(root.right, low, high);
        if (root.val > high) return helper(root.left, low, high);
        root.left = helper(root.left, low, high);
        root.right = helper(root.right, low, high);
        return root;
    }
}
