package com.leetcode.Date0912;


import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 设有n维数组，元素分别为a00  a01 ... a0(n-1) a10 a11 ... a1(n-1) ... ... a(n-1)0 a(n-1)1 ... a(n-1)(n-1)，求其相加和最大子数组的值max
 *
 * 输入
 * n
 *
 * a00  a01 ... a0(n-1) a10 a11 ... a1(n-1) ... ... a(n-1)0 a(n-1)1 ... a(n-1)(n-1)
 *
 * （数据范围：n在1到100之间，每个数在-128到127之间）
 *
 * 输出
 * max
 *
 *
 * 样例输入
 * 2
 * -1 2 -3 6
 * 样例输出
 * 8
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(line);
        System.out.println(getMax(2, new int[]{-1,2,-3,6}));
    }

    // n代表数组的维度 items 代表数组元素
    public static int getMax(int n, int[] items){
        // n位数组代表有n行
        // 让第i行数据与第j行数据相加
        for (int i = 0; i < n; i++){

        }
        int result = 0;
        for (int i = 0; i < n; i++){
            result += items[items.length-1-i];
        }
        return result;

    }
}
