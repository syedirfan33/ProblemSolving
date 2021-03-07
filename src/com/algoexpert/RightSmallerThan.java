package com.algoexpert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RightSmallerThan {
    // Same as count of smaller numbers after self
    // nlogn, Inserting into BST would take logn time.
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        List<Integer> res = new ArrayList<>();
        if (array.size() == 0) return res;
        res.add(0);
        BST node = new BST(array.get(array.size() - 1));
        for (int i = array.size() - 2; i >= 0; i--) {
            int cur = node.insert(array.get(i));
            res.add( cur);
        }
        Collections.reverse(res);
        return res;
    }

    static class BST {
        int count = 1;
        int value;
        BST left;
        BST right;

        public BST(int value) {
            this.value = value;
        }

        private int insert(int value) {
            BST root = this;
            int smallerNodes = 0;
            while (true) {
                if (value <= root.value) {
                    root.count++;
                    if (root.left == null) {
                        root.left = new BST(value);
                        break;
                    } else {
                        root = root.left;
                    }
                } else {
                    smallerNodes += root.count;
                    if (root.right == null) {
                        root.right = new BST(value);
                        break;
                    } else {
                        root = root.right;
                    }
                }
            }
            return smallerNodes;
        }
    }
}
