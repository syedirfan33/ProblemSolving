/**
 * 
 */
package com.algoexpert;

import com.algoexpert.RemoveNthNode.LinkedList;

/**
 * @author Syed Irfan
 *
 */
public class FindLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(4 * (4 - 1) / 2);
	}

	public static LinkedList findLoop(LinkedList head) {
		LinkedList first = head.next;
		LinkedList second = head.next.next;
		while(first!=second) {
			first = first.next;
			second = second.next.next;
		}
		first = head;
		while(first!=second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	static class LinkedList{
		int value ;
		LinkedList next = null;
		
		LinkedList(int value){
			this.value = value;
		}
	}
	
}
