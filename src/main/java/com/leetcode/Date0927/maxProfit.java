package com.leetcode.Date0927;

// leetcode 122买卖股票的最佳时机2 允许多次买入卖出 但是最多持有一份股票
public class maxProfit {
    // 思路1 贪心算法  只要明天的价格大于今天的价格，我们就今天买入明天卖出（明天可以继续买入）
    public int maxProfit(int[] prices) {
        // 贪心算法 只要今天的价格小于明天 我们就今天买入明天卖出
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i]<prices[i+1]){
                profit += prices[i+1]-prices[i];
            }
        }
        return profit;
    }

    // 思路2 动态规划
    // 效率虽然不高但是代表着一个思路
    public int maxProfit1(int[] prices) {

        if (prices == null || prices.length <= 1){
            return 0;
        }
        // 利用动态规划来解决这个问题
        // 第i天股票的状态为两种 持有和不持有 第i天的持有可能是第i-1天的持有也可能是第i天购入
        // 第i天的不持有 可能是第i-1天不持有，也可能是第i-1天持有，第i天卖出
        // dp[i][] 表示净利润
        int[][] dp = new int[prices.length][2];
        // dp[i][0]表示未持有
        // dp[i][1]表示持有
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            // 今天的未持有状态可能是昨天未持有 也可能是昨天持有 但是今天卖出
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
