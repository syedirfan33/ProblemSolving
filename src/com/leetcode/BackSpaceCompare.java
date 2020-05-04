/**
 * 
 */
package com.leetcode;

import java.util.Stack;

/**
 * @author Syed Irfan
 *
 */
public class BackSpaceCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("y#fo##f",
				"y#f#o##f"));
	}

	
    public static boolean backspaceCompare(String S, String T) {
    	return buildString(S).equals(buildString(T));
    }
    
    private static String buildString(String s) {
    	Stack<Character> stack = new Stack<>();
    	for(char c:s.toCharArray()) {
    		if(c == '#' && !stack.isEmpty()) {
    			stack.pop();
    		}else {
    			stack.push(c);
    		}
    	}
    	System.out.println(String.valueOf(stack));
    	return String.valueOf(stack);
    }
}
