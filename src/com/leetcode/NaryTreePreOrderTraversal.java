package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreOrderTraversal {
    List<Integer> res;

    public List<Integer> preorder(Node root) {
        res = new ArrayList<>();
        helper(root);
        return res;
    }

    private void helper(Node node) {
        if (node == null)
            return;
        res.add(node.val);
        for (Node other : node.children) {
            helper(other);
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
