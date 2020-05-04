/**
 * 
 */
package com.algoexpert;

import java.util.Stack;

/**
 * @author Syed Irfan
 *
 */
public class CheckValidString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean checkValidString(String s) {
        if(s.trim().length() == 0) return true;
        
        Stack<Integer> open = new Stack<>();
        Stack<Integer> ast = new Stack<>();
        
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open.push(i);
            }else if(s.charAt(i) == '*'){
                ast.push(i);
            }else{
               if(!open.isEmpty()) open.pop();
               else if(!ast.isEmpty()) ast.pop();
                else return false;
            }
        }
        
        while(!open.isEmpty()){
           if(ast.isEmpty() || open.pop() > ast.pop()) return false; 
        }
        return true;
    }

}
