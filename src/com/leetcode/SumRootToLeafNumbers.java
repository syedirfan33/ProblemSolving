package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

/**
 * @author Syed Irfan - 27/06/2020
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0, new StringBuilder());
    }
    
    private int helper(TreeNode root, int res, StringBuilder sb) {
        if (root == null) return res;
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(sb.toString());
            return res;
        }
        int length = sb.length();
        res = helper(root.left, res, sb);
        if (root.left != null) sb.delete(length, sb.length());
        res = helper(root.right, res, sb);
        return res;
    }
}
