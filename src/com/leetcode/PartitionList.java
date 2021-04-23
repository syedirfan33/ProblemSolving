package com.leetcode;

public class PartitionList {

    // Yey, solved it myself.
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode firstHead = first, secondHead = second;
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = secondHead.next;
        return firstHead.next;
    }

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
}
