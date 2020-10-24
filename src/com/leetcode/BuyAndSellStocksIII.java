package com.leetcode;

import java.util.Arrays;

public class BuyAndSellStocksIII {
    public int maxProfit(int[] prices) {
        int[][][] mem = new int[prices.length][2][3];
        for (int i = 0; i < mem.length; i++) {
            for (int j = 0; j < mem[0].length; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return maxProfitHelper(mem, prices, 1, 2, 0);
    }

    private int maxProfitHelper(int[][][] mem, int[] prices, int isBuy, int noOfTxn, int index) {
        if (index >= prices.length || noOfTxn == 0) return 0;
        if (mem[index][isBuy][noOfTxn] != -1) return mem[index][isBuy][noOfTxn];
        int res = 0;
        if (isBuy == 1) {
            int buy = maxProfitHelper(mem, prices, 0, noOfTxn, index + 1) - prices[index];
            int noBuy = maxProfitHelper(mem, prices, 1, noOfTxn, index + 1);
            res = Math.max(buy, noBuy);
        } else {
            int sell = maxProfitHelper(mem, prices, 1, noOfTxn - 1, index + 1) + prices[index];
            int noSell = maxProfitHelper(mem, prices, 0, noOfTxn, index + 1);
            res = Math.max(sell, noSell);
        }
        mem[index][isBuy][noOfTxn] = res;
        return res;
    }
}
