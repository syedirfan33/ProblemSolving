package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

/**
 * @author Syed Irfan - 13/07/2020
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
