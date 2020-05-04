/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class BitwiseAnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rangeBitwiseAnd(0, 2147483647));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		StringBuilder a = new StringBuilder(Integer.toBinaryString(m));
		StringBuilder res = new StringBuilder();
		if(m == n) {
			return Integer.parseInt(doAnd(a, a).toString(), 2) ;
		}
		for(int i=m+1;i<=n;i++) {
			StringBuilder b = new StringBuilder(Integer.toBinaryString(i));
			res = doAnd(a, b);
			a = res;	
		}
		
		return Integer.parseInt(res.toString(), 2);
	}
	
	private static StringBuilder doAnd(StringBuilder a, StringBuilder b) {
		int i = a.length()-1;
		int j = b.length()-1;
		int minLen = Math.min(i, j);
		StringBuilder res = new StringBuilder();
		while(minLen >= 0) {
			if(a.charAt(i) == '1' && b.charAt(j) == '1') {
				res.append("1");
			}else {
				res.append("0");
			}
			i--;
			j--;
			minLen--;
		}
		return res.reverse();
	}

}
