/**
 * 
 */
package com.leetcode;

import java.util.Stack;

/**
 * @author Syed Irfan
 *
 */
public class MinStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min_stack = new Stack<>();
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(min_stack.isEmpty() || x <= min_stack.peek()){
            min_stack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.peek().equals(min_stack.peek())){
            min_stack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
    }

}
