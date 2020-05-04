/**
 * 
 */
package com.leetcode;

import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class AssignCookies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findContentChildren(int[] g, int[] s) {
	       Arrays.sort(g);
	       Arrays.sort(s);
	       int contentChildren = 0;
	       int i = g.length - 1;
	       int j = s.length - 1;
	       while(i>=0 && j>=0){
	           if(s[j] >= g[i]){
	               contentChildren++;
	               j--;
	               i--;
	           }else{
	               i--;
	           }
	       } 
	        return contentChildren;
	    }

}
