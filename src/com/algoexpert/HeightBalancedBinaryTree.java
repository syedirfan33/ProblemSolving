package com.algoexpert;

public class HeightBalancedBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    boolean res = true;

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        helper(tree);
        return res;
    }

    private int helper(BinaryTree tree) {
        if (tree == null || !res)
            return 0;
        int leftH = 1 + helper(tree.left); // or we can skip adding 1 here and return 1 + Math.max(leftH, rightH);
        int rightH = 1 + helper(tree.right);
        if (Math.abs(leftH - rightH) > 1) {
            res = false;
        }
        return Math.max(leftH, rightH);
    }

}

