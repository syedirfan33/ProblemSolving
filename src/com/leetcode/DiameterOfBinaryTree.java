/**
 *
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class DiameterOfBinaryTree {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int leftH = helper(root.left);
        int rightH = helper(root.right);
        int diameter = leftH + rightH;
        res = Math.max(res, diameter);
        int height = 1 + Math.max(leftH, rightH);
        return height;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
