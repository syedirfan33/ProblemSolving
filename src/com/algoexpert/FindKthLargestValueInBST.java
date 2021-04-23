package com.algoexpert;

public class FindKthLargestValueInBST {
    // I solved it
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    int res = Integer.MAX_VALUE;
    int count = 0;

    public int findKthLargestValueInBst(BST tree, int k) {
        helper(tree, k);
        return res;
    }

    private void helper(BST tree, int k) {
        if (tree == null || res != Integer.MAX_VALUE)
            return;
        helper(tree.right, k);
        count++;
        if (count == k) {
            res = tree.value;
            return;
        }
        helper(tree.left, k);
    }
}
