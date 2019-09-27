package com.leetcode.Date0927;

// leetcode 309 买卖股票的最佳时机 喊冷冻期
public class maxProfit1 {
    public int maxProfit(int[] prices) {
        // 排除特殊情况
        if (prices == null || prices.length <= 1){
            return 0;
        }
        // 求卖出股票的最大利润 创建一个二维数组 dp[i][0]代表未持有股票 dp[i][1]代表持有股票 dp[i][2]代表处于处于冷冻期
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        // 初始化成未冻结的状态
        for (int i = 1; i < prices.length; i++){
            // 第i天没有持有股票可能的情况有
            // 第i-1天也不持有股票或者是第i-1是冻结期
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]);

            // 第i天持有的情况
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);

            // 第i天是冷冻期的情况
            dp[i][2] = dp[i-1][1]+prices[i];
        }
        // 股票的最大利润
        return Math.max(dp[prices.length-1][0], dp[prices.length-1][2]);

    }
}
