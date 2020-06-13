package com.leetcode;

import com.leetcode.CompleteBinaryTree.*;

/**
 * @author Syed Irfan - 01/06/2020
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    
}
