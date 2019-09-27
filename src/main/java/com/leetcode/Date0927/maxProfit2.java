package com.leetcode.Date0927;

//leetcode 714买入卖出股票的最佳时刻（含手续费）
public class maxProfit2 {
    // 含手续费的股票买卖活动
    // 卖出一次收费为fee
    public int maxProfit(int[] prices, int fee) {
        // 排除特殊情况
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        // 利用动态规划 使用动态转移方程

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 股票只有两种状态持有和未持有 dp[i][0]表示未持有 dp[i][1]表示持有
        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
