package com.leetcode.Date0906;

import java.util.ArrayList;
import java.util.List;

//leetcode 46全排列问题
public class Permute {
    private List<List<Integer>> res;

    // 回溯算法一般使用递归方式求解
    // 全排列问题 使用回溯算法求解
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        // 创建一个结果数组 用来暂存每一种可能出现的解
        int[] result = new int[nums.length];
        getNumN(0, nums, result);
        return res;
    }

    // 将问题分为n个阶段(n为数组的长度) 每个阶段对应找到一个数字 找到了一个数字之后要检验和之前的数字有重复吗
    private void getNumN(int n, int[] nums, int[] result){
        // 当n 为数组的长度的时候代表已经找到的是一个满足的解
        if (n == nums.length){
            // 根据result数组输出结果到最终的集合之中
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < result.length; i++){
                temp.add(result[i]);
            }
            res.add(temp);
            return;
        }
        // 当n不为nums.length说明还在寻找解
        // 下面是确定第n为数字的值
        for (int i = 0; i < nums.length; i++){
            if (isOK(n, nums[i], result)){
                result[n] = nums[i];
                getNumN(n + 1, nums, result);
            }
            // 不满足的话 回溯
        }
    }

    // 看选中的数字是否有和之前选中的重复的
    private static boolean isOK(int cal, int value, int[] result){
        for (int i = 0; i < cal; i++){
            if (value == result[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Permute p = new Permute();
        p.permute(nums);
        System.out.println(p.res);
    }


}
