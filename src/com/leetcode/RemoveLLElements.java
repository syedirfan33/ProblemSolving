package com.leetcode;

import com.leetcode.LLPalindrome.ListNode;

/**
 * @author Syed Irfan - 21/07/2020
 */
public class RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode fakeHead = new ListNode(-1, head);
        ListNode node = fakeHead;
        while(fakeHead.next != null){
            if(fakeHead.next.val == val){
                fakeHead.next = fakeHead.next.next;
            }else{
                fakeHead = fakeHead.next;
            }
        }
        return node.next;
    }
}
