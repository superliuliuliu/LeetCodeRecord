package com.leetcode.Date0908;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// leetcode 216
// 第一次出错是因为忽略了 n只能取1-9内的正整数
public class CombinationSum3 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.combinationSum3(2,18));
    }
}

class Solution {

    private List<List<Integer>> result;

    // 相加之和为n的k个数的组合
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        // 特殊情况
        if (n <= 0 || k <= 0){
            return result;
        }
        getCombinationSum(n, k, new Stack<>(), n, 1);
        return result;
    }

    // remain代表剩下的值 而n代表可以取值的范围
    // 既要限制数目为k个数 又要限制和为n
    private void getCombinationSum(int remain, int k, Stack<Integer> stack, int n, int start){
        if (remain == 0){
            if (stack.size() == k){
                result.add(new ArrayList<>(stack));
            }
        }else if (remain < 0){
            return;
        }

        // 第一次提交的错误答案 忽略了可供选择的数是有序的1-9
//        for (int i = start; i <= n && remain - i >= 0; i++ ){
        for (int i = start; i <= 9 && remain - i >= 0; i++ ){
            stack.push(i);
            getCombinationSum(remain - i, k, stack, n, i + 1);
            stack.pop();
        }
    }

}
