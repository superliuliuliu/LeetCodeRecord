package com.leetcode.Date0906;

// 回溯算法之八皇后问题
public class Queen8 {
    // 将问题分为8个阶段，每一个阶段依次将8枚棋子放置在第0行、第1行..第7行的位置上
    // 返回的结果 用来代表每一行中皇后的所在列数
    private static int[] result = new int[8];

    // 第row行的棋子放置 调用时从第0行开始
    private void calqueens(int row){
        // 递归的终止条件
        if (row == 8){
            // 当row==8时代表八行已经完成了放置 所以结束循环
            // 打印八皇后的位置信息
            printQueen(result);
            return;
        }
        // 当row != 8时 说明未完成放置 一行中的每一列都有可能放置
        for (int column = 0; column < 8; column++){
            // 判断当前的放置是否满足要求 不满足要求column向下 满足要求则进行下一行的配置
            if (isOK(row, column)){
                // 将满足情况的结果（列的位置）加入到结果数组中
                result[row] = column;
                calqueens(row + 1);
            }
            // 不满足的话因为 之前没有对结果数组进行操作 所以不需要回退 只需遍历下一个列即可
        }
    }

    // 判断当前的情况是否满足
    // row代表行数 column代表放置的列数 而之前的放置结果存放在全局变量result之中
    private static boolean isOK(int row, int column){
        // row行数之前的数据（result数据）代表之前行数中棋子所在的列数
        for (int i = 0; i < row; i++){
            // 当为同列时直接不满足条件
            if (column == result[i] || column == row - i + result [i] || column == result[i] - row + i){
                return false;
            }
        }
        return true;
    }

    //打印二维矩阵
    private static void printQueen(int[] result){
        for (int i = 0; i < result.length; i++){
            for (int column = 0; column < result.length; column++){
                if (result[i] == column){
                    System.out.print("Q");
                }
                else {
                    System.out.print("*");
                }
            }
            // 换行
            System.out.println();
        }
        // 换行
        System.out.println();
    }

    public static void main(String[] args) {
        new Queen8().calqueens(0);
    }


}
