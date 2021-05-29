package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras {
    int res;
    Set<TreeNode> set;

    // Video from algorithms made easy, see solution 2 for optimised approach
    // The intuition is NOT TO SET cameras at leaf nodes.
    public int minCameraCover(TreeNode root) {
        set = new HashSet<>();
        res = 0;
        set.add(null);
        dfs(root, null);
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null)
            return;
        dfs(node.left, node);
        dfs(node.right, node);
        if ((parent == null && !set.contains(node)) || (!set.contains(node.left) || !set.contains(node.right))) {
            res++;
            set.add(node);
            set.add(node.left);
            set.add(node.right);
            set.add(parent);
        }
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
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
