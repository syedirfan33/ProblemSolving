package com.leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {

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

    // O(KN) , where K is length of list and N is total number of nodes. Solution Inspired from Merge 2 sorted lists.
    // Check solution 2 for optimized approach using priority queue
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode cur = merge(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            cur = merge(cur, lists[i]);
        }
        return cur;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                head.next = l1;
                l1 = l1.next;
            } else {
                head.next = l2;
                l2 = l2.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        else head.next = l2;
        return dummy.next;
    }

    public ListNode mergeKListsII(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for(ListNode node: lists){
            if(node != null) queue.add(node);
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!queue.isEmpty()){
            ListNode cur = queue.remove();
            head.next = cur;
            head = head.next;
            if(cur.next != null) queue.add(cur.next);
        }
        return dummy.next;

    }
}
