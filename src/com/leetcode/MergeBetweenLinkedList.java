package com.leetcode;

public class MergeBetweenLinkedList {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode second = list1;
        for (int i = 1; i < a; i++) {
            second = second.next;
        }
        ListNode third = second;
        for (int i = a; i <= b; i++) {
            third = third.next;
        }
        second.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = third.next;
        return list1;
    }
}
