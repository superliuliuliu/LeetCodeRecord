package com.leetcode.Date0925;

// leetcode 279 完全平方数
public class numSquares {

    // 动态规划算法 超时
    public int numSquares(int n) {
        if (n <= 0){
            return 0;
        }
        // 完全平方数最多的情况为 完全平方数全为1
        int max = n;
        // 状态转移表格
        boolean[][] state = new boolean[n][n+1];

        // 初始化状态转移表格  第一行
        for (int i = 1; (i*i) <= n; i++){
            state[0][i*i] = true;
        }

        for (int i = 1; i < max; i++){
            for (int j = 0; j <= n; j++){
                if (state[i-1][j] == true){
                    // 所有可能的平方数
                    for (int k = 1; (k*k) <= n; k++){
                        if ((j+(k*k)) <= n){
                            state[i][j+(k*k)] = true;
                        }
                    }
                }
            }
        }
        int min = max;
        for (int i = 0; i < max; i++){
            if (state[i][n] == true){
                min = i;
                return min + 1;
            }
        }
        return min;

    }
}
