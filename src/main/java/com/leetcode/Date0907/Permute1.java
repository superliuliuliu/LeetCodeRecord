package com.leetcode.Date0907;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute1 {
    private List<List<Integer>> result;

    private boolean[] used;

    // 全排列问题进阶 解决的是可能包含重复数字的序列 这个问题需要我们进行剪枝操作
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        // 创建一个是否使用的数组
        used = new boolean[nums.length];
        // 默认为未使用
        Arrays.fill(used, true);
        int[] resultTemp = new int[nums.length];
        // 首先对数组进行排序
        Arrays.sort(nums);
        getNumN(0, nums, resultTemp);
        return result;

    }

    // 同样将问题分为n个阶段
    // n代表第n个数字 nums代表题目提供的源数组
    private void getNumN(int n, int[] nums, int[] resultTemp){
        if (n == nums.length){
            // 已经完成了操作 得到了一组满意的解
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < resultTemp.length; i++){
                temp.add(resultTemp[i]);
            }
            result.add(temp);
            return;
        }
        // 遍历源数组 找到第n位数字可能的解
        for (int i = 0; i < nums.length; i++){
            // 判断之前的数字是否重复使用了
            if (isOK(i)){
                // 除了做赋值操作 外我们还需要对使用的过的数字做标识
                resultTemp[n] = nums[i];
                // 标明第i个数字已经使用
                used[i] = false;
                getNumN(n + 1, nums, resultTemp);
            }
            // 不符合的话回溯
        }

    }

    private boolean isOK(int index){
        return used[index];
    }
}
