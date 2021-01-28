package com.leetcode;

import com.leetcode.LLPalindrome.ListNode;

/**
 * @author Syed Irfan - 31/05/2020
 */
public class AddTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            ListNode cur = new ListNode(sum % 10);
            res.next = cur;
            res = res.next;
        }
        if (carry > 0) res.next = new ListNode(carry);
        return dummy.next;
    }
}
