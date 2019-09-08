package com.leetcode.Date0907;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// Leetcode 47全排列问题II
public class Permute1 {
    class Solution {

        private List<List<Integer>> result = new ArrayList<>();

        private boolean[] used;

        // 全排列问题进阶 解决的是可能包含重复数字的序列 这个问题需要我们进行剪枝操作
        public List<List<Integer>> permuteUnique(int[] nums) {

            // boolean数组 将该数字是否使用标注出来 将每个数字的使用状态置为未使用
            used = new boolean[nums.length];
            Arrays.fill(used, false);
            // 对数组进行排序 方便后面的去重操作
            Arrays.sort(nums);
            getNumN(0, nums, new Stack<>());

            return result;
        }

        // 同样将问题分为n个阶段
        // n代表第n个数字 nums代表题目提供的源数组
        private void getNumN(int n, int[] nums, Stack<Integer> stack){
            // 表明已经得到了一个想要的结果 结果存储在stack中
            if (n == nums.length){
                result.add(new ArrayList<>(stack));
            }
            // 当n小于源数组的长度之时 说明还在寻找可能的值
            for (int i = 0; i < nums.length; i++){
                // 判断源数组中下标为i的元素是否使用
                if (!used[i]){
                    // 如果未使用 需要先考虑可能出现重复的解的情况
                    // 需要特别注意我们应该剪枝的是哪种情况？不仅仅是两数相等我们就应该剔除
                    // 而是在两数相等的前提下 且两数都未被使用 这样无论先选择你还是先选择我 最终的结果是一样的 我们需要注意这一点
                    if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                        continue;
                    }
                    // 加入结果之中
                    stack.add(nums[i]);
                    // 标记为已使用
                    used[i] = true;
                    // 寻找下一个数字
                    getNumN(n + 1, nums, stack);
                    // 出递归之后 要进行状态重置
                    used[i] = false;
                    stack.pop();
                }
                // 如果已经使用那么我们回溯遍历下一个值
            }
        }
    }
}
