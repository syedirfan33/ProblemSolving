/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class ReorderList {

	/**
	 * @param args
	 */
	

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public void reorderList(ListNode head) {

		if (head == null || head.next == null)
			return;

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		ListNode l1 = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;

		ListNode l2 = reverse(slow);
		System.out.println(l2);
		merge(l1, l2);
	}

	ListNode reverse(ListNode head) {
		ListNode p1 = null;
		ListNode p2 = head;
		while (p2 != null) {
			ListNode p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}

		return p1;
	}


	void merge(ListNode l1, ListNode l2) {
		while (l1 != null) {

			ListNode l1_next = l1.next;
			ListNode l2_next = l2.next;

			l1.next = l2;

			if (l1_next == null) {
				break;
			}
			l2.next = l1_next;

			l1 = l1_next;
			l2 = l2_next;
		}

	}

}
