/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class BackSpaceCompare2 {
	public boolean backspaceCompare(String S, String T) {
	        StringBuilder s1 = new StringBuilder();
	        StringBuilder s2 = new StringBuilder();
	        for(int i=0;i<S.length();i++){
	            appendOrRemove(s1, S.charAt(i), i);
	        }
	         for(int i=0;i<T.length();i++){
	            appendOrRemove(s2, T.charAt(i), i);
	        }
	        System.out.println(s1.toString());
	        System.out.println(s2.toString());
	        return s1.toString().equals(s2.toString());
	    }
	    
	    public static void appendOrRemove(StringBuilder sb, char c, int i){
	        if(sb.length() == 0 && c == '#') return;
	        if(c!='#') sb.append(c);
	        else{
	            sb.deleteCharAt(sb.length()-1);
	        }
	        
	    }	
}

