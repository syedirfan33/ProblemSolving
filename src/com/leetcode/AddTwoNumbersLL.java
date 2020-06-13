package com.leetcode;

import com.leetcode.LLPalindrome.*;

/**
 * @author Syed Irfan - 31/05/2020
 */
public class AddTwoNumbersLL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode res = dummyHead;
        while(l1 != null || l2 != null){
            int cur = l1 != null ? l1.val : 0;
            int cur2 = l2 != null ? l2.val : 0;
            int curRes = cur + cur2 + carry;
            carry = curRes / 10;
            curRes = curRes % 10;
            ListNode curNode = new ListNode(curRes);
            res.next = curNode;
            res = res.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if(carry != 0) res.next = new ListNode(carry);
        return dummyHead.next;
    }
}
