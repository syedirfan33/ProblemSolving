package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromSortedListII {

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


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        Map<Integer, Integer> map = new HashMap<>();

        ListNode res = dummy;
        while (head != null && head.next != null) {
            if (!map.containsKey(head.val) && head.val != head.next.val) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            head = head.next;
        }
        if (!map.containsKey(head.val)) dummy.next = head;
        return res.next;
    }
}
