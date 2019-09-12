package com.leetcode.Date0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// leetcode 60 第k个排列
public class KthElement {
    // 阶乘数组 0的阶乘根据规定我们将其置为1
    private List<String> result;
    private int[] factorialNums = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    private boolean[] used;

    public  String getPermutation(int n, int k) {
        used = new boolean[n];
        // 将是否使用过全部置为未使用过
        Arrays.fill(used, false);
        result = new ArrayList<>();
        getKth(n,0, new StringBuilder(), k);
        return result.get(k-1);

    }

    // 特点每个数字只能使用一次
    // n 代表总有n个数字可选 order 代表第几个数字 subset代表当前字符串集合
    private void getKth(int n, int order, StringBuilder subset, int k){
        if (result.size() > k){
            return;
        }
        if (order == n){
            // order等于n时 说明了已经得到了一种结果
            result.add(subset.toString());
            return;
        }

        // 遍历可选的剩下数字
        for (int i = 0; i < n; i++){
            // 判断当前数字是否使用过
            if (!used[i]){
                used[i] = true;
                subset.append(i + 1);
                getKth(n, order + 1, subset, k);
                // 状态重置
                used[i] = false;
                subset.deleteCharAt(subset.length() - 1);
            }
            // 使用过的话回溯下一个
        }

    }

    public static void main(String[] args) {
        KthElement k = new KthElement();
        System.out.println(k.getPermutation(4,9));
    }
}

class solve2{
    // 阶乘数组 0的阶乘根据规定我们将其置为1
    private int[] factorialNums = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    private boolean[] used;

    public  String getPermutation(int n, int k) {
        used = new boolean[n];
        // 将是否使用过全部置为未使用过
        Arrays.fill(used, false);
        return getKth(n,0, new StringBuilder(), k);

    }

    // 特点每个数字只能使用一次
    // n 代表总有n个数字可选 order 代表第几个数字 subset代表当前字符串集合
    private String getKth(int n, int order, StringBuilder subset, int k){
        if (order == n){
            // order等于n时 说明了已经得到了一种结果
            return subset.toString();
        }
        // leafNums 为在当前情况下 所有可能出现的全排列情况
        // order代表已经选了几个数字
        int leafNums = factorialNums[n - 1 - order];
        // 遍历可选的剩下数字
        for (int i = 0; i < n; i++){
            // 如果已经使用 那么我们判断下一个数字
            if (used[i]){
                continue;
            }
            // leafNums 为在当前情况下 所有可能出现的全排列情况
            if (k > leafNums){
                // 对k进行操作因为是 下一个节点的第k个全排列
                k -= leafNums;
                continue;
            }
            // k < leafNums 说明解在其中
            used[i] = true;
            subset.append(i + 1);
            return getKth(n, order + 1, subset, k);
            // 不需要重置因为只得到了一种解
        }
        throw new RuntimeException();
    }
}
