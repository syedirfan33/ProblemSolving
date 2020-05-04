/**
 * 
 */
package com.algoexpert;

/**
 * @author Syed Irfan
 *
 */
public class RemoveNthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void removeNthNode(LinkedList head, int k) {
		int counter = 1;
		LinkedList first = head;
		LinkedList second = head;
		while(counter<=k) {
			second = second.next;
		}
		
		if(second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		
		while(second.next != null) {
			first = first.next;
			second = second.next;
		}
		first.next = first.next.next;
	}
	
	static class LinkedList{
		int value ;
		LinkedList next = null;
		
		LinkedList(int value){
			this.value = value;
		}
	}

}
