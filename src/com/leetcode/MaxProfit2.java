/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class MaxProfit2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1] > prices[i]){
                maxProfit += prices[i+1] - prices[i];
            }
        }
        return maxProfit;
    }

}
