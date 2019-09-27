package com.leetcode.Date0924;

// leetcode 64 最小路径之和
public class minPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null){
            return 0;
        }
        // n代表列数 m代表行数
        int n = grid.length;
        int m = grid[0].length;

        // 初始化第一列和第一行的数据
        for (int i = 1; i < n; i++){
            grid[i][0] += grid[i-1][0];
        }

        for (int i = 1; i < m; i++){
            grid[0][i] += grid[0][i-1];
        }

        // 动态转换方程 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+dp[i][j];
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                grid[i][j] += Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }

        return grid[n-1][m-1];
    }
}
