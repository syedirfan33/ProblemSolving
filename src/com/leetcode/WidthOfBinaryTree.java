package com.leetcode;

import com.leetcode.CompleteBinaryTree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Syed Irfan - 09/07/2020
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int res = 0;
        if (root == null) return 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            while (!queue.isEmpty() && queue.peek() == null) queue.remove();
            while (!queue.isEmpty() && queue.peekLast() == null) queue.removeLast();
            int size = queue.size();
            res = Math.max(size, res);
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                
            }
        }
        return res;
    }
}
