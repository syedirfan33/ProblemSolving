package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syed Irfan - 21/05/2020
 */
public class BinaryTreeInOrderTraversal {
    public List<Integer> inOrderTraversal(CompleteBinaryTree.TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(CompleteBinaryTree.TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
