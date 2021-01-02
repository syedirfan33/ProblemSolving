package com.leetcode;

public class SwapNodesInPairs {
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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head; // To handle [] and [1];
        ListNode prev = dummy, cur = head;
        while (cur != null && cur.next != null) {
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = cur;
            cur = cur.next;
            prev = prev.next.next;
        }
        return dummy.next;
    }
}
