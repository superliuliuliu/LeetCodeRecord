package com.leetcode.Date0925;

// 求最长公共子串
public class maxLen {
    public int minDistance(String word1, String word2) {
        int strLen1 = word1.length();
        int strLen2 = word2.length();
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        if (strLen1 == 0 || strLen2 == 0){return 0;}
        int[][] state = new int[strLen2][strLen1];

        //初始化第一行和第一列
        for (int i = 0; i < strLen1; i++){
            if (str1[i] == str2[0]){
                state[0][i] = 1;
            }else if( i != 0){
                state[0][i] = state[0][i-1];
            }else{
                state[0][i] = 0;
            }
        }
        for (int i = 0; i < strLen2; i++){
            if (str2[i] == str1[0]){
                state[i][0] = 1;
            }else if (i != 0){
                state[i][0] = state[i-1][0];
            }else{
                state[i][0] = 0;
            }
        }

        for (int i = 1; i < strLen2; i++){
            for (int j = 1; j < strLen1; j++){
                if (str1[i] == str2[j]){
                    state[i][j] = getMax(state[i-1][j], state[i][j-1], state[i-1][j-1] + 1);
                }else{
                    state[i][j] = getMax(state[i-1][j], state[i][j-1], state[i-1][j-1]);
                }
            }
        }
        return state[strLen2-1][strLen1-1];
    }

    private int getMax(int a, int b, int c){
        int max = a;
        if (b>max){
            max = b;
        }
        if (c>max){
            max = c;
        }
        return max;
    }
}
