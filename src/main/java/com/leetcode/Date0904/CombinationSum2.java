package com.leetcode.Date0904;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// 组合总和 进阶1 给定的数字可能包含重复值 要求每个数字只能使用一次
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null){
            return result;
        }
        // 对数组进行排序操作
        Arrays.sort(candidates);
        findCombinationSum(target, 0, result, new Stack(), candidates);
        return result;

    }

    private void findCombinationSum(int remain, int start, List<List<Integer>> result, Stack stack, int[] candidates){
        if (remain == 0){
            result.add(new ArrayList<>(stack));
            return;
        }else if (remain < 0){
            return;
        }
        for (int i = start; i < candidates.length && remain - candidates[i] >= 0; i++){
            // 剪枝去重操作 数组是经过排序的数组 这里的去重指的是相同的结果集合 而不是集合中一个解中不能有重复的数字
            // i > start 是为了防止出现candidates[i-1]不在区间范围内的情况
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }

            stack.add(candidates[i]);
            findCombinationSum(remain - candidates[i], i + 1, result, stack, candidates);
            // 回溯返回到上一个节点的状态
            stack.pop();
        }

    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(new CombinationSum2().combinationSum2(candidates, target));
    }
}
