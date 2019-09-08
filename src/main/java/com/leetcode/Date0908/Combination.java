package com.leetcode.Date0908;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// LEETCODE 39
/*
* 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
* */
public class Combination {
    private List<List<Integer>> result;

    // 问题分析 是找1至n内 所有可能的k个数的组合 将这个问题分为k个阶段
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        // n小于k时 不存在解
        if (n <= 0 || k <= 0 || n < k){
            return result;
        }
        //
        getCombine(1, n, k, new Stack<>());
        return result;
    }

    // num代表选了那个数  n代表1..n即可供选择数字的范围  k代表要选择k个数字
    private void getCombine(int num, int n, int k, Stack<Integer> stack){
        // 说明已经找到了一个满足的解
        if (stack.size() == k){
            result.add(new ArrayList<>(stack));
            return;
        }
        // k-stack.size() 代表要组成解还需要元素的数目 n代表全部元素的数目 因为不能出现重复的现象可选择元素的最大值为 n - (k - stack.size())
        // 要求选择出满足要求的值
        for (int i = num; i <= n - (k - stack.size()) + 1; i++){
            stack.push(i);
            // 递归求解
            getCombine(i, n, k, stack);
            // 状态重置
            stack.pop();
        }
    }
}
