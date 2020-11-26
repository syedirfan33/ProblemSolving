package com.leetcode;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = head, second = head, prev = dummy;
        for (int i = 0; i < n; i++) {
            first = first.next; // Move first to N distance away
        }
        while (first != null) {
            prev = second;
            second = second.next;
            first = first.next;
        } // At the end, second and first will be N distance away. so we have to remove node at second pointer
        prev.next = second.next;
        return dummy.next;
    }
}
