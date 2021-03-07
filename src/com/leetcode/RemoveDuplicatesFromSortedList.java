package com.leetcode;

public class RemoveDuplicatesFromSortedList {
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
        ListNode node = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return node;
    }

    // Without using extra space
    public ListNode deleteDuplicatesII(ListNode head) {
        ListNode res = new ListNode();
        while(res.next != null){
            if(res.val == res.next.val){
                res.next = res.next.next;
            }else{
                res = res.next;
            }
        }
        return res;
    }
}
