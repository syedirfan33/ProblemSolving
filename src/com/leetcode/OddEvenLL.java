/**
 * 
 */
package com.leetcode;

import com.leetcode.ReorderList.ListNode;

/**
 * @author Syed Irfan
 *
 */
public class OddEvenLL {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	 public ListNode oddEvenList(ListNode head) {
	        if(head == null) return null;
	        ListNode odd = head;
	        ListNode even = odd.next;
	        ListNode evenHead = even;
	        
	        while(even!=null && even.next!=null){
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        
	        odd.next = evenHead;
	        return head;
	    }
}
