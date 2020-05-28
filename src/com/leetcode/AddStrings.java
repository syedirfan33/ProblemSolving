/**
 *
 */
package com.leetcode;

import java.util.Date;

/**
 * @author Syed Irfan
 *
 */
public class AddStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addStrings("9", "1"));
	}

	public static String addStrings(String num1, String num2) {

        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int sum = 0;
        while(i>=0 || j>=0 ) {
            sum = carry;

            if(i>=0){
                sum+=num1.charAt(i) - '0';
                i--;
            }
            if(j>=0){
                sum+=num2.charAt(j) - '0';
                j--;
            }
            carry = sum / 10;
            res.append(sum%10);
        }
        if(carry > 0)res.append(carry);
        return res.reverse().toString();
    }

}
