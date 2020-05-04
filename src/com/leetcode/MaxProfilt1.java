/**
 * 
 */
package com.leetcode;

/**
 * @author Syed Irfan
 *
 */
public class MaxProfilt1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minVal) minVal = prices[i];
            else maxProfit = Math.max(maxProfit, prices[i] - minVal);
        }
        return maxProfit;
    }
}
