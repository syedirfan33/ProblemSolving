package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> li1 = new ArrayList<>();
        while (l1 != null) {
            li1.add(l1.val);
            l1 = l1.next;
        }
        if (li1.size() == 0) return l2;

        List<Integer> li2 = new ArrayList<>();
        while (l2 != null) {
            li2.add(l2.val);
            l2 = l2.next;
        }
        if (li2.size() == 0) return l1;

        ListNode res = new ListNode(0);
        int carry = 0;
        int i = li1.size() - 1, j = li2.size() - 1;
        while (i >= 0 || j >= 0) {
            int sum = 0;
            if (i >= 0) {
                sum += li1.get(i);
                i--;
            }
            if (j >= 0) {
                sum += li2.get(j);
                j--;
            }
            sum += carry;
            res.val = sum % 10;
            carry = sum / 10;
            ListNode head = new ListNode(carry);
            head.next = res;
            res = head;

        }
        return carry == 0 ? res.next : res;
    }


    //Using stacks.
    public ListNode addTwoNumbersII(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        if (s1.isEmpty()) return l2;

        Stack<Integer> s2 = new Stack<>();
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        if (s2.isEmpty()) return l1;

        int carry = 0;
        ListNode res = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = 0;
            if (!s1.isEmpty()) sum += s1.pop();
            if (!s2.isEmpty()) sum += s2.pop();
            sum += carry;

            res.val = sum % 10;
            carry = sum / 10;
            ListNode cNode = new ListNode(carry);
            cNode.next = res;
            res = cNode;
        }
        return res.val != 0 ? res : res.next;
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
