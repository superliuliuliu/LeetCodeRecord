package com.leetcode.Date0909;

import java.util.ArrayList;
import java.util.List;

// leetcode 22 回溯问题
public class Generatehesis {
    // 注意题目要求是所有生成有效的括号组合
    // 题目类似于全排列 但是关键问题在于剪枝 即减去不符合要求的解
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n <= 0){
            return result;
        }
        getHesis(0, 0, n, new StringBuilder());
        return result;
    }

    // 使用两个计数器 分别用来记录左括号的数量和右括号的数量 n代表生成括号的对数
    private void getHesis(int left, int right, int n, StringBuilder subset){
        // 因为是递归调用可能出现 left=n但是right>n 或者相反的情况 这种直接抛弃
        if (left > n || right > n){
            return;
        }
        if (left == n && right == n){
            // 说明左右括号凑齐了
            result.add(subset.toString());
            return;
        }

        if (left >= right){
            StringBuilder temp = subset;
            subset.append(")");
            getHesis(left, right + 1, n, subset);
            // 状态恢复
            subset.deleteCharAt(subset.length() - 1);

            subset.append("(");
            getHesis(left + 1, right, n, subset);
            //状态恢复
            subset.deleteCharAt(subset.length() - 1);
        }
    }
}
