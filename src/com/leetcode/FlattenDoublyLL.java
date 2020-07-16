package com.leetcode;

import java.util.Stack;

/**
 * @author Syed Irfan - 11/07/2020
 */
public class FlattenDoublyLL {
    
    public Node flatten(Node head) {
        Node first = new Node();
        Node resHead = first;
        if (head == null) return null;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            if (cur != null) {
                if (cur.child != null) {
                    stack.push(cur.next);
                    stack.push(cur.child);
                } else {
                    stack.push(cur.next);
                }
                cur.next = null;
                cur.child = null;
                cur.prev = null;
                first.next = cur;
                cur.prev = first;
                first = first.next;
            }
        }
        resHead.next.prev = null;
        return resHead.next;
    }
    
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
