package com.leetcode.Date0922;

// leetcode 121 买卖股票的最好时机
/*
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/*
思路 使用动态规划的思想 令dp[i]代表前i天最大的收益 dp[i] = Math.max(dp[i-1], prices[i]-min);
 */
public class maxProfit {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        // 一共有n天
        // 使用动态规划来解决此题
        int[] profit = new int[prices.length];
        profit[0] = 0;
        // 前i天的最大收益 = max(前i-1天的最大收益，第i天的价格-前i-1天的最低价格)
        int min = prices[0];
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            if (i >= 1){
                profit[i] = Math.max(profit[i-1], prices[i]-min);
            }
        }
        return profit[prices.length-1];
    }
}
