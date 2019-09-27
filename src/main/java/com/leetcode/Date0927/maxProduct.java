package com.leetcode.Date0927;

// leetcode 152 乘积的最大子序列
// 题目要求求最大的连续乘积值  如果数组中没有负数我们完全可以从头乘到尾部
// 但是数组中可能包含一个负数
// 我们首先声明一个值作为最大值 用它记录最大值 当出现一个新的最大值 我们用它和新的最大值比较
// 同时我们需要保存另外两个数 一个最大值 一个最小值 因为数组中存在负数 当出现负数时 最大值就会变成最小值 最小值反而会变成最大值
public class maxProduct {
    // 求乘积最大的  连续子序列的乘积
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        // 用来暂存最大值和最小值
        // 设置为1也是有用处的
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
