package com.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InsertionSortList {
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

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode prev = dummy;
        while (head != null) {
            while (prev.next != null && prev.next.val < head.val) {
                prev = prev.next;
            }
            ListNode temp = head.next;
            head.next = prev.next;
            prev.next = head;
            head = temp;
            prev = dummy;
        }
        return dummy.next;
    }
}
