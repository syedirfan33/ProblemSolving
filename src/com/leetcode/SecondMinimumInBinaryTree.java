package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

import java.util.PriorityQueue;

/**
 * @author Syed Irfan - 22/06/2020
 */
public class SecondMinimumInBinaryTree {
    
    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> res = new PriorityQueue<>();
        helper(res, root);
        if (res.size() <= 1) return -1;
        res.remove();
        return res.remove();
    }
    
    private void helper(PriorityQueue<Integer> res, TreeNode root) {
        if (root == null) return;
        if (res.isEmpty()) res.add(root.val);
        else if (res.peek() != root.val) res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
    }
    
}
