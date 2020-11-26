package com.leetcode;

public class ReverseBetween {

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


    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        ListNode prevNode = dummyHead;
        ListNode start = head;
        int count = m;
        while (count > 1) {
            prevNode = prevNode.next;
            start = start.next;
            count--;
        }
        prevNode.next = reverse(start, n - m + 1);
        return dummyHead.next;
    }


    private ListNode reverse(ListNode head, int n) {
        if (head == null || head.next == null) return head;
        ListNode prev = null, cur = head, next = null;
        while (n > 0 && cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            n--;
        }
        head.next = cur; // Now, head is the tail of newly reversed list. and I am pointing head.next to cur(which is not reversed/ yet to be reversed)
        return prev;
    }
}
