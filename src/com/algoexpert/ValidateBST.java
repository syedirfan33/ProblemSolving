package com.algoexpert;

import java.util.*;

class Program {
    public static boolean validateBst(BST tree) {
        return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean helper(BST tree, int minVal, int maxVal) {
        if (tree == null) return true;
        if (tree.val < minVal || tree.val >= maxVal) return false;
        return helper(tree.left, minVal, tree.val) && helper(tree.right, tree.val, maxVal);
    }

    static class BST {
        public int val;
        public BST left;
        public BST right;

        public BST(int value) {
            this.val = value;
        }
    }

}
