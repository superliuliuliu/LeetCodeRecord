package com.leetcode.Date0923;

import java.util.Arrays;

// 01背包问题的升级 要求的是背包中物品的价值最高
public class DPpackage01Value {

    private void getMaxValue(int[] weight, int[] value, int MAXW){
        int count = weight.length;
        int[][] stateValue = new int[count][MAXW+1];
        // 首先填充满-1代表此种情况不会发生
        for(int i = 0; i < count; i++){
            Arrays.fill(stateValue[i], -1);
        }
        // 初始化第一行
        stateValue[0][0] = 0;
        stateValue[0][weight[0]] = value[0];
        // 共有count个物品 第一个物品的可能已经填充
        for (int i = 1; i < count; i++){
            // 利用上一个阶段的值推断出下一个阶段的值
            // 遍历上一个阶段
            for (int j = 0; j <= MAXW; j++){
                if (stateValue[i-1][j] >= 0){
                    // 不放置的情况 价值+0
                    if (stateValue[i-1][j] > stateValue[i][j]){
                        stateValue[i][j] = stateValue[i-1][j];
                    }
                    // 放置的情况 防止数组越界
                    if ((j + weight[i]) <= MAXW){
                        int v = value[i] + stateValue[i-1][j];
                        if (v > stateValue[i][j+weight[i]]){
                            stateValue[i][j+weight[i]] = v;
                        }
                    }
                }
            }
        }
        int maxValue = value[0];
        for (int i = MAXW; i >= 0; i--){
            if (maxValue < stateValue[count-1][i]){
                maxValue = stateValue[count-1][i];
            }
        }
        System.out.println(maxValue);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3,4,2,11,20};
        int[] values = new int[]{10,3,1,9,25};
        DPpackage01Value dPpackage01Value = new DPpackage01Value();
        dPpackage01Value.getMaxValue(weights, values, 20);
    }
}
