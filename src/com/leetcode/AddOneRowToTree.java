package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode newRoot = new TreeNode(v);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 2;
        boolean ret = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (level == d) {
                    if (cur.left != null) {
                        TreeNode temp = cur.left;
                        cur.left = new TreeNode(v);
                        cur.left.left = temp;
                    } else {
                        cur.left = new TreeNode(v);
                    }
                    if (cur.right != null) {
                        TreeNode temp = cur.right;
                        cur.right = new TreeNode(v);
                        cur.right.right = temp;
                    } else {
                        cur.right = new TreeNode(v);
                    }
                    ret = true;
                } else {
                    if (cur.left != null) queue.add(cur.left);
                    if (cur.right != null) queue.add(cur.right);
                }
            }
            if (ret) break;
            level++;
        }
        return root;
    }

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
            this.left = left;
            this.right = right;
        }
    }
}
