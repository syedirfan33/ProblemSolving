/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class DublicateIntegerInArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] {1,5,3,4,2,5}));

	}
	
	public static int findDuplicate(int[] array) {
		int slow = array[0];
		int fast = array[0];
		while(true) {
			slow = array[slow];
			fast = array[array[fast]];
			
			if(slow == fast) {
				break;
			}
		}
			int ptr1 = array[0];
			int ptr2 = slow;
			while(ptr1 != ptr2) {
				ptr1 = array[ptr1];
				ptr2 = array[ptr2];
			}
			
			return ptr1;
		
	}

}
