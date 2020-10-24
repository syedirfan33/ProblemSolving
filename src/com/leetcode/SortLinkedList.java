package com.leetcode;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(slow);
        return mergeList(firstHalf, secondHalf);
    }

    private ListNode mergeList(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                dummy.next = first;
                first = first.next;
            } else {
                dummy.next = second;
                second = second.next;
            }
            dummy = dummy.next;
        }
        if (first != null) dummy.next = first;
        else dummy.next = second;
        return head.next;
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
