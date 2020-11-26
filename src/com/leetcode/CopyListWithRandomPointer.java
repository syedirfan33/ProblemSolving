package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    //My solution
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node ori = head;
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node res = newHead;
        Node out = newHead;
        while (head != null) {
            newHead.next = head.next == null ? null : new Node(head.next.val);
            map.put(head, newHead);
            newHead = newHead.next;
            head = head.next;
        }
        while (ori != null) {
            Node cur = map.get(ori.random);
            res.random = cur;
            res = res.next;
            ori = ori.next;
        }
        return out;
    }

    //a bit clever and concise solution
    public Node copyRandomList2(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();

        // loop 1. copy all the nodes
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers - It changes the references
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
