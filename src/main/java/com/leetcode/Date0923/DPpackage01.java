package com.leetcode.Date0923;

//  01背包问题的动态规划写法
/*
思路：动态规划的核心思想在于利用上一步已知的信息推导出下一步所有的可能的信息  最终求最优解
 */
public class DPpackage01 {

    public int getMaxWeight(int[] weight, int pMaxWeight){
        int result = 0;
        // count代表物品数目 pMaxWeight代表背包所能承受的最大重量
        int count = weight.length;
        // 将问题分解成n个阶段 每个阶段有两种情况 装载或者不装载
        // 状态数组 存储
        boolean[][] state = new boolean[count][pMaxWeight + 1];
        // 初始化 第一行数据
        state[0][0] = true;
        state[0][weight[0]] = true;
        for (int i = 1; i < count; i++){
            for (int j = 0; j <= pMaxWeight; j++){
                if (state[i-1][j] == true){
                    // 不放入背包的情况
                    state[i][j] = true;
                    // 放入背包的情况
                    if ((j + weight[i]) <= pMaxWeight){
                        state[i][j+weight[i]] = true;
                    }
                }
            }
        }
        // 遍历state数组得到解
        for (int i = pMaxWeight; i >= 0; i--){
            if (state[count-1][i] == true){
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3,4,2,5,21};
        DPpackage01 dPpackage01 = new DPpackage01();
        System.out.println(dPpackage01.getMaxWeight(weights, 20));
    }
}
