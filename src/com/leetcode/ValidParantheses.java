/**
 * 
 */
package com.leetcode;

import java.util.*;

/**
 * @author Syed Irfan
 *
 */
public class ValidParantheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("{()}"));
	}
	
	public static boolean isValid(String s) {
		String open = "({[";
		String close = ")}]";
		Map<Character, Character> couple = new HashMap<>();
		couple.put(')', '(');
		couple.put('}', '{');
		couple.put(']', '[');
		List<Character> stack = new ArrayList<Character>();
		
		
		for(int i=0;i<s.length();i++) {
			Character cur = s.charAt(i);
			if(open.indexOf(cur) !=-1) {
				stack.add(cur);
			}else if(close.indexOf(cur)!=-1) {
				if(stack.size() == 0 || couple.get(cur) != stack.get(stack.size()-1)) return false;
				stack.remove(stack.size()-1);
			}
		}
		return stack.size() == 0;
	}

	// Another easy solution

	public boolean isValidII(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()){
			if(c == '(' || c == '{' || c == '[') stack.push(c);
			else{
				if(stack.isEmpty()) return false;
				char top = stack.pop();
				if(top != getPair(c)) return false;
			}
		}
		return stack.isEmpty();
	}

	private char getPair(char c){
		switch(c){
			case ')': return '(';
			case ']': return '[';
			case '}': return '{';
			default: return ' ';
		}
	}

}
