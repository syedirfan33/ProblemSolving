package com.algoexpert;

import java.util.*;

/**
 * @author Syed Irfan - 25/05/2020
 */
public class NodeDepths {
    public static int nodeDepths(BinaryTree root) {
        Queue<BinaryTree> stack = new LinkedList<>();
        int res = 0;
        int level = 1;
        stack.add(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                BinaryTree cur = stack.remove();
                if (cur.left != null) {
                    stack.add(cur.left);
                    res += level;
                }
                if (cur.right != null) {
                    stack.add(cur.right);
                    res += level;
                }
            }
            level++;
        }
        return res;
    }
    
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;
        
        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}

