package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
    // I coded myself. The idea is to have list of nodes which have value equal to t and then exploring one by one to check equality
    List<TreeNode> nodes = new ArrayList<>();

    public boolean isSubtree(TreeNode s, TreeNode t) {
        findNodes(s, t);
        for (TreeNode node : nodes) {
            if (validate(node, t)) return true;
        }
        return false;
    }

    private boolean validate(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null || s.val != t.val) return false;
        return validate(s.left, t.left) && validate(s.right, t.right);
    }

    private void findNodes(TreeNode s, TreeNode t) {
        if (s == null) return;
        if (s.val == t.val) {
            nodes.add(s);
        }
        findNodes(s.left, t);
        findNodes(s.right, t);
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
