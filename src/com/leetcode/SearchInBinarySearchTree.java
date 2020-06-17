package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

/**
 * @author Syed Irfan - 15/06/2020
 */
public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
