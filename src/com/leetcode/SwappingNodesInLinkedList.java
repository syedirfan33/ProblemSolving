package com.leetcode;

public class SwappingNodesInLinkedList {

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


    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head, second = head;
        while (k != 1) {
            first = first.next;
            k--;
        }

        // at the end of while loop, second and third nodes are k distance away from each other.
        ListNode third = first;
        while (third != null && third.next != null) {
            second = second.next;
            third = third.next;
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
        return head;
    }
}
