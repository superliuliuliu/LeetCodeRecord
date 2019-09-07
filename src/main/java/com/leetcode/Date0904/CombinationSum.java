package com.leetcode.Date0904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 求组合总和为指定值的所有可能解
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果数据集合为空 则返回空
        if (candidates == null){
            return result;
        }
        // 提供的数据数组是无序的 我们先经过排序操作  是为了进行剪枝去重 因为有序的数组进行下面的操作 下一个路径都会大于等于上一个路径
        Arrays.sort(candidates);
        // 调用函数递归执行
        findCombinationSum(target, 0, candidates, new Stack(), result);
        return result;

    }

    // 找到解 remain代表经过几次减操作剩下的值 start表示从数组开始遍历的值
    private void findCombinationSum(int remain, int start, int[] candidates, Stack stack, List<List<Integer>> result){
        // remain == 0代表符合要求的数组 将数据添加到结果集合之中
        if (remain == 0){
            // 将栈添加到结果集合之中
            result.add(new ArrayList<>(stack));
            return;
        }// remain < 0代表不符合要求 不做任何操作
        else if (remain < 0){
            return;
        }

        // 开始递归调用 求解 当remain-candidates[i] > 0 时 代表符合要求且可以继续递归寻找下去
        for (int i = start; i < candidates.length && remain - candidates[i] >= 0; i++){
            // candidates[i]符合要求 将其加入到栈中
            stack.add(candidates[i]);
            // 递归寻找下一个合适的解 直至remain <= 0
            // 仍然从当前节点开始 因为数据可以重复 这个函数将执行到结束（递归调用）最终remain < 0
            // 当remian == 0时 会直接返回结果而不会把结果给弹出
            findCombinationSum(remain - candidates[i], i, candidates, stack, result);

            //当remain < 0 时开始回溯 弹出最后一个不符合的解，使上一个remain >= 0
            stack.pop();

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum().combinationSum(candidates, target));
    }
}
