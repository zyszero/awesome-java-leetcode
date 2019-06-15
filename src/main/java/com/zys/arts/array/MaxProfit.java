package com.zys.arts.array;

/**
 * @Author: Created by zys
 * @Description:
 * @Date: 2019/4/28 23:27
 * @Modified By:
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
