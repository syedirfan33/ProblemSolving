/**
 * 
 */
package com.leetcode;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * @author Syed Irfan
 *
 */
public class AssignCookies {

	/**
	 * @param args
	 */

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

	public static void main(String[] args) {
		Instant start = Instant.now();

		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
	}

}
