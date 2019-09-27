package com.leetcode.Date0925;

// leetcode 72 编辑距离
public class minDistance {

    // 思路见笔记
    public int minDistance(String word1, String word2) {
        // 元字符串的长度
        int sourceLen = word1.length();
        // 目的字符串的长度
        int targetLen = word2.length();
        if (sourceLen == 0){
            return targetLen;
        }
        if (targetLen == 0){
            return sourceLen;
        }

        char[] source = word1.toCharArray();
        char[] target = word2.toCharArray();

        //构建状态转移表格
        int[][] state = new int[targetLen][sourceLen];

        // 初始化第一行和第一列
        for (int i = 0; i < sourceLen; i++){
            if (source[i] == target[0]){
                state[0][i] = i;
            }else if (i != 0){
                state[0][i] = state[0][i-1] + 1;
            }else{
                state[0][i] = 1;
            }
        }
        for (int i = 0; i < targetLen; i++){
            if (target[i] == source[0]){
                state[i][0] = i;
            }else if(i != 0){
                state[i][0] = state[i-1][0]+1;
            }else{
                state[i][0] = 1;
            }
        }

        // 补充状态转换表
        for (int i = 1; i < targetLen; i++){
            for (int j = 1; j < sourceLen; j++){
                if (target[i] == source[j]){
                    // 字符相等
                    state[i][j] = getMin(state[i-1][j-1], state[i-1][j]+1, state[i][j-1]+1);
                }else{
                    // 字符不等
                    state[i][j] =getMin(state[i-1][j-1]+1, state[i-1][j]+1, state[i][j-1]+1);
                }
            }
        }
        return state[targetLen-1][sourceLen-1];
    }

    private int getMin(int a, int b, int c){
        int min = a;
        if (min > b){
            min = b;
        }
        if (min > c){
            min = c;
        }
        return min;
    }

    // 解法1 回溯算法 超时
//    private int editDis;
//    public int minDistance(String word1, String word2) {
//        int n = word1.length();
//        int m = word2.length();
//
//        // 将字符串转换为字符数组
//        char[] str1 = word1.toCharArray();
//        char[] str2 = word2.toCharArray();
//        // 最大的编辑距离为 两个字符串的数组长度之和
//        editDis = n + m;
//        getResult(0, 0, 0, str1, str2);
//        return editDis;
//    }
//
//    // i代表字符串1的下标 j代表字符串2的下标 count代表当前的编辑距离
//    private void getResult(int i, int j, int count,  char[] str1, char[] str2){
//        int n = str1.length;
//        int m = str2.length;
//        if (i == n || j == m){
//            if (i < n){
               // i和j代表前面已经比对过i或者j个字符了
//                count += (n - i);
//            }
//            if (j < m){
//                count += (m - j);
//            }
//            if (count < editDis){
//                editDis = count;
//            }
//            return;
//        }
//        // 字符串匹配的话
//        if (str1[i] == str2[j]){
//            getResult(i+1, j+1, count, str1, str2);
//        }else{
//            // 不匹配的话
//            // 执行删除操作
//            getResult(i+1, j, count+1, str1, str2);
//            // 执行插入操作
//            getResult(i, j+1, count+1, str1, str2);
//            // 执行替换操作
//            getResult(i+1, j+1, count+1, str1, str2);
//        }
//    }
}
