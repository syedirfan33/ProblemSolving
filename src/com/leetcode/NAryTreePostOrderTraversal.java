package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NAryTreePostOrderTraversal {
    // My solution, but follow up is to do it iteratively
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }

    private void helper(Node root) {
        if (root == null) return;
        if (root.children != null) {
            for (Node node : root.children) helper(node);
        }
        res.add(root.val);
    }

    public List<Integer> postorderII(Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            res.add(cur.val);
            for(Node n: cur.children) stack.add(n);
        }
        Collections.reverse(res);
        return res;
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

    ;

}
