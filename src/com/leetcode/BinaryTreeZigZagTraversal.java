package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetcode.CompleteBinaryTree.TreeNode;

public class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isReverse = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> cur = new ArrayList<>();
            List<CompleteBinaryTree.TreeNode> nextQueue = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.remove();
                cur.add(curNode.val);
                if (isReverse) {
                    if (curNode.right != null) {
                        nextQueue.add(0, curNode.right);
                    }
                    if (curNode.left != null) {
                        nextQueue.add(0, curNode.left);
                    }
                } else {
                    if (curNode.left != null) {
                        nextQueue.add(0, curNode.left);
                    }
                    if (curNode.right != null) {
                        nextQueue.add(0, curNode.right);
                    }
                }
            }
            isReverse = !isReverse;
            queue.addAll(nextQueue);
            res.add(cur);
        }
        return res;
    }

}
