package com.algoexpert;

public class MaxPathSumInBinaryTree {
    // See leetcode's official solution explanation or nick white's video for better understanding
    static int[] res = new int[1];

    public static int maxPathSum(BinaryTree tree) {
        res[0] = Integer.MIN_VALUE;
        dfs(tree);
        return res[0];
    }

    private static int dfs(BinaryTree node) {
        if (node == null) return 0;
        int left = Math.max(0, dfs(node.left)); // If the value is -ve, we disregard that node
        int right = Math.max(0, dfs(node.right));
        res[0] = Math.max(res[0], left + right + node.value);
        return Math.max(left, right) + node.value;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
