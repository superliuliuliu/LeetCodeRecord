package com.leetcode.Date0906;

// 01背包问题
// 一个背包的最大装载重量为w kg, 我们有n个重量不等的物品，求在不超过背包的装载重量的前提下，如何让背包的装载重量最大
public class Package01 {

    // 回溯算法的解决方法将问题分解成每个阶段 确定每个阶段的任务

    private int maxW = 0;// 背包最终装载的最大重量

    // i代表装到了第i个物品 i从0开始 cw代表当前背包的重量
    // 要求 背包的最大重量为Weight kg ,每个物品的重量存储在int[] items数组之中 要求返回的结果为一个数组 0代表该物品未装载，1，代表该物品被装载
    private void getMax(int[] items, int i, int cw, int Weight){
        // i==n时 代表已经考察完了所有物品 所能装载的最大重量即为当前的重量
        // 当当前重量等于最大重量时 我们也就不需要递归后面的结果了 因为值最大的可能就是Weight
        if (i == items.length || cw == Weight){
            if (maxW < cw){
                maxW = cw;
            }
            return;
        }
        // 不装载此背包向下遍历 不装载的情况是一定需要的（因为这一定是一种满足条件的解）
        getMax(items, i + 1, cw, Weight);

        // 如果 装载本背包后仍然小于最大值 那么我们选择装载 即代表装载本背包出错的话我们没有必要向下遍历了
        if (items[i] + cw <= Weight){
            getMax(items, i + 1, cw + items[i], Weight);
        }
        // 这里出了一点问题考虑问题不全面所导致
        // 之前错误的想法实现的代码如下 但是实际情况是我们应该遍历所有的可能情况 即使此背包不装载，我们也应该进入相关的递归 毕竟当前仍然满足要求
//        if (items[i] + cw > Weight){
//            // 进入到一个回溯递归 不装载该背包
//            getMax(items, i + 1, cw, Weight);
//        }else{
//            cw += items[i];
//            // 进入到另外一个回溯递归 装载该背包
//            getMax(items, i + 1, cw, Weight);
//        }
    }

    public static void main(String[] args) {
        int[] weights = new int[]{3,4,2,5,21};
        Package01 P = new Package01();
        P.getMax(weights, 0, 0, 20);
        System.out.println(P.maxW);
    }
}
