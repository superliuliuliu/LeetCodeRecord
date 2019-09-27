package com.leetcode.Date0925;

import java.util.Arrays;

/*
给定硬币币值，求凑齐w的最少硬币数
 */
public class forLessCoins {

//    private int coinChange(int[] coins, int amount){
////        if (coins == null || coins.length == 0){
////            return -1;
////        }
////
////        // 币值数组按升序排列 且一般最小币值为1
////        int maxRow = amount / coins[0];
////        // 创建状态转移表 默认为false 一共maxRow行 totalValue+1列 元素为true代表有解
////        boolean[][] state = new boolean[maxRow][amount + 1];
////        // 初始化第一行状态
////        for(int i = 0; i < coins.length; i++){
////            state[0][coins[i]] = true;
////        }
////
////        // 开始填充状态转移表
////        for (int i = 1; i < maxRow; i++){
////            for (int j = 0; j <= amount; j++){
////                // 找到上一行状态不为空的数据
////                if (state[i-1][j] != false){
////                    // 添加一个硬币  币值随意
////                    for (int k = 0; k < coins.length; k++) {
////                        if ((coins[k] + j) <= amount) {
////                            state[i][coins[k] + j] = true;
////                        }
////                    }
////                }
////            }
////        }
////
////        int min = -1;
////        for (int i = 0; i < maxRow; i++){
////            if (state[i][amount] == true){
////                min = i;
////                return min + 1;
////            }
////        }
////        return min;
////        // 遍历数组找到最小的硬币数
////    }

    public int coinChange(int[] coins, int amount){
        // 没有硬币的话 代表没有办法找零 故返回-1
        if(coins == null || coins.length == 0){
            return -1;
        }
        // 不需要找零的情况
        if (amount == 0){
            return 0;
        }
        // 状态转换数组 dp[i]表示凑齐i元的最小硬币数
        int[] dp = new int[amount + 1];
        // 状态转换方程为 dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++){
            for (int j = 0; j < coins.length && i - coins[j] >= 0; j++){
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        forLessCoins one = new forLessCoins();
        int[] coins = new int[]{2};
        System.out.println(one.coinChange(coins, 3));
    }
}
