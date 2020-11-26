package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    ;

    // O(n) time and O(n) space solution
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (cur.right != null) queue.add(cur.right);
                if (cur.left != null) queue.add(cur.left);
                cur.next = prev;
                prev = cur;
            }
        }
        return root;
    }

    // Recursion based solution
    public Node connectII(Node root) {
        if(root == null) return null;
        helper(root);
        return root;
    }

    private void helper(Node root){
        if(root == null || root.left == null) return;
        root.left.next = root.right;
        if(root.next != null) root.right.next = root.next.left; // No need to check because tree is perfect                binary tree
        connect(root.left);
        connect(root.right);
    }
}
