/**
 * 
 */
package com.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Syed Irfan
 *
 */
public class BalancedBrackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(balancedBrackets("())"));
	}

	public static boolean balancedBrackets(String str) {
		String open = "({[";
		String close = ")}]";
		Map<Character, Character> brackets = new HashMap<>();
		brackets.put('}', '{');
		brackets.put(')', '(');
		brackets.put(']', '[');
		List<Character> stack = new ArrayList<Character>();
		
		for(int i=0;i<str.length();i++) {
			Character current = str.charAt(i);
			if(close.indexOf(current)!= -1) {
				if(stack.size() == 0) return false;
				if(brackets.get(current) == stack.get(stack.size()-1)) {
					stack.remove(stack.size()-1);
				}else {
					return false;
				}
			}else if(open.indexOf(current)!= -1) {
				stack.add(current);
			}
		}
		return stack.size() == 0;
	}
}
