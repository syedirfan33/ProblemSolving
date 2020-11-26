package com.leetcode;

public class RangeSum {

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


    int res = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        rangeSum(root, low, high);
        return res;
    }

    private void rangeSum(TreeNode root, int low, int high) {
        if (root == null) return;
        if (root.val >= low && root.val <= high) {
            res += root.val;
            rangeSum(root.left, low, high);
            rangeSum(root.right, low, high);
        } else if (root.val <= low) {
            if (root.val == low) res += root.val;
            rangeSum(root.right, low, high);
        } else {
            if (root.val == high) res += root.val;
            rangeSum(root.left, low, high);
        }
    }
}
