/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class PerformStringShifts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/
	public String stringShift(String s, int[][] shift) {
        char[] inp = s.toCharArray();
        for(int[] pair : shift){
            if(pair[0] == 0) shiftLeft(pair[1], inp);
            else shiftRight(pair[1], inp);
        }
        return new String(inp);
    }
    
    private void shiftLeft(int num, char[] chars){
        while(num>0){
            char leftChar = chars[0];
            for(int i=0;i<chars.length-1;i++){
                chars[i] = chars[i+1];
            }
            chars[chars.length - 1] = leftChar;
            num--;
        }
    }
    
     private void shiftRight(int num, char[] chars){
        while(num>0){
            char rightChar = chars[chars.length - 1];
            for(int i=chars.length - 1;i>0;i--){
                chars[i] = chars[i-1];
            }
            chars[0] = rightChar;
            num--;
        }
    }
	
}
