package com.leetcode;

public class BuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int res = 0;
        if (prices.length == 0) return 0;
        int bought = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > bought) {
                int profit = prices[i] - bought;
                res = Math.max(profit, res);
            } else {
                bought = prices[i];
            }
        }
        return res;
    }
}
