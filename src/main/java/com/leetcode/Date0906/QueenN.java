package com.leetcode.Date0906;


import java.util.ArrayList;
import java.util.List;

public class QueenN {
    public static List<List<String>> output = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        // 声明一个长度为n的数组用来代表 第n行棋子是在第result[n]列
        int[] result = new int [n];
        calnQueens(0, n, result);
        return output;
    }

    // n 皇后问题 row代表计算到了到第row行
    private static void calnQueens(int row, int n, int[] result){
        if (row == n){
            // 到达第n行代表已经得到一个将解决方案 直接返回即可
            // 根据result数组将结果加入到output列表中
            getPrint(result);
            return;
        }
        // 若不是第n行 则说明需要继续判断该行棋子应该在那一列
        for (int column = 0; column < n; column++){
            // 判断第row行 放置在column列的棋子是否满足要求
            if (isOK(row, column, result)){
                result[row] = column;
                // 递归判断下一行的情况
                calnQueens(row + 1, n, result);
            }
            // 不满足要求 回溯下一列 对应操作column++
        }
    }

    // row代表行数 column代表列数 result代表满足规则的棋子在第n行中的位置
    private static boolean isOK(int row, int column, int[] result){
        // 判断棋子的位置是否正确 不正确返回false
        for (int i = 0; i < row; i++){
            // 第一个条件排除的是相同列的问题
            // 第二个条件排除的是对角线列的左下角
            // 第三个条件排除的是对角线列的右下角
            if (column == result[i] || column == result[i] - row + i || column == result[i] + row - i){
                return false;
            }
        }
        return true;
    }

    private static void getPrint(int[] result){
        List<String> one = new ArrayList<>();
        for (int row = 0; row < result.length; row++){
            // 一行一个StringBuilder
            StringBuilder str = new StringBuilder();
            for (int column = 0; column < result.length; column++){
                if (column == result[row]){
                    str.append("Q");
                }else{
                    str.append(".");
                }
            }
            one.add(str.toString());
        }
        output.add(one);
    }

    public static void main(String[] args) {
        System.out.println(new QueenN().solveNQueens(8));
    }
}

class test{
    private int count;

    // 暂存每行棋子的所在列
    private int[] result;

    public int totalNQueens(int n) {
        count = 0;
        result = new int[n];

        if (n <= 0){
            return count;
        }
        getQueenN(0, n, result);
        return count;
    }

    // row代表第几行放置棋子
    private void getQueenN(int row, int n, int[] result){
        // 表明已经有一个满足的结果
        if (row == n){
            count++;
        }
        // row 小于n代表未满足
        // 开始遍历找合适的解
        for (int i = 0; i < n; i++){
            // 判断将棋子放在i列是否合适
            if (isOK(row, i, result)){
                // 代表第row行棋子的位置在i列
                result[row] = i;
                getQueenN(row + 1, n, result);
            }
            // 不合适的话回溯
        }
    }

    private boolean isOK(int row, int cal, int[] result){
        // 遍历以前的满足的解 剔除不符合要求的
        for (int i = 0; i < row; i++){
            if (cal == result[i] || cal == result[i] + row - i|| cal == result[i] - row + i){
                return false;
            }
        }

        return true;
    }
}
