/**
 *
 */
package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan
 *
 */
public class LLPalindrome {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
    }
    
    public boolean isPalindrome(ListNode head) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while (slow != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return head;
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
        
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        
    }
    
}
