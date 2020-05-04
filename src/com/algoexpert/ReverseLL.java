/**
 * 
 */
package com.algoexpert;

import com.algoexpert.FindLoop.LinkedList;

/**
 * @author Syed Irfan
 *
 */
public class ReverseLL {

	
	public static LinkedList reverse(LinkedList head) {
		LinkedList p1 = null;
		LinkedList p2 = head;
		while(p2!=null) {
			LinkedList p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		return p1;
	}
	
	static class LinkedList{
		int value ;
		LinkedList next = null;
		
		LinkedList(int value){
			this.value = value;
		}
	}
}
